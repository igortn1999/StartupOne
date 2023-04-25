# Set the base image to use
FROM postgres:latest

# Set the database environment variables
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD admin
ENV POSTGRES_DB postgres

# Create a volume to store data
VOLUME /var/lib/postgresql/data

# Set the maximum size of the volume
RUN echo "max_wal_size = 5GB" >> /usr/share/postgresql/postgresql.conf

# Expose the default Postgres port
EXPOSE 5432

# Start the Postgres server
CMD ["postgres"]
