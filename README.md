# Delta Format Implementation in Java

This project contains a Java implementation of the Delta Lake transaction protocol, providing a simplified but functional version of the core Delta Lake concepts.

## Overview

The implementation includes:

1. **Action Classes**: Basic building blocks for the Delta transaction log
   - `Protocol`: Defines the minimum reader and writer versions
   - `CommitInfo`: Contains metadata about a commit
   - `AddFile`: Represents adding a file to the table
   - `RemoveFile`: Represents removing a file from the table
   - `Metadata`: Contains table metadata

2. **Transaction System**:
   - `Transaction`: Basic transaction support with atomic commits
   - `OptimisticTransaction`: Advanced transaction with optimistic concurrency control

3. **JSON Serialization/Deserialization**:
   - `JsonUtil`: Handles conversion between action objects and JSON strings using Jackson

## Key Features

- **ACID Transactions**: All changes to Delta tables are made atomically through transactions
- **Optimistic Concurrency Control**: Detects and prevents concurrent modification conflicts
- **JSON-based Transaction Log**: Actions are serialized to JSON for storage
- **Multiple Isolation Levels**: Supports Serializable and WriteSerializable isolation
- **Automatic Retry**: Configurable automatic retry on conflict detection
- **Checkpoint Mechanism**: Supports checkpointing of table state for faster loading
- **Snapshot Isolation**: Point-in-time view of the table

## Getting Started

### Prerequisites

- Java 17
- Gradle for building

#### Install java 11
   ```bash
   brew install openjdk@17
   ```

#### Install Gradle (if not installed)
   ```bash 
   brew install gradle
   ```
   
#### Generate gradle wrapper
   ```bash 
   gradle wrapper
   ``` 

### Building

```bash
./gradlew build
```

### Running Tests

```bash
./gradlew test
```

### Running Examples

```bash
# Run the basic DeltaApp demo
./gradlew run

# Run the Transaction Example with concurrent transactions
./gradlew runExample
```

## Project Structure

```
src/main/java/com/example/deltajava/
├── util/
│   ├── FileNames.java     # Delta file naming utilities
│   ├── CsvUtil.java       # CSV processing utilities
│   ├── ParquetUtil.java   # Parquet file handling
├── DeltaTable.java        # Table operations example
```

TODO:
1. Try to pass the test ```testReadAllRecords()``` by implementing the missing pieces of code 
2. Try to pass the test ```testConsecutiveInserts()``` by implementing the missing pieces of code