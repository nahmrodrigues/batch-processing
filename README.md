## Batch Processing Application

### Running Locally

1. Run redis server:
    `sudo docker-compose up`

2. Define Run/Debug configurations:

   - Choose main class: `BatchProcessingApplication`

   - Set environment variables: `DB_REDIS_HOST=localhost;DB_REDIS_PASSWORD=redis123456`
     
   - Set VM Options: `-Dspring.profiles.active=dev`

3. Run the application