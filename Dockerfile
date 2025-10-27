# Stage 1: The Builder
FROM openjdk:17-jdk-slim as builder
WORKDIR /app

# Step 1: Copy pom.xml and maven wrapper first. This is a cache breakpoint.
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -B

# Step 2: Copy ALL source code (This is a second cache breakpoint)
# Note: You were copying 'RecipeNotes/src', assuming the RecipeNotes directory is at the root.
COPY RecipeNotes/src ./src

# Step 3: Package the application. The '-parameters' flag is now redundant due to pom.xml but harmless.
RUN ./mvnw package -DskipTests

# Stage 2: The Final Production Image (minimal runtime)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar