# Ballooner Application

Ballooner is an application designed for making files larger by expanding small datasets as quickly as possible. The structure of the balloon data is similar to the input data, with the probability of occurrence of each field preserved. The basis for data generation is an object, and the application allows the generation of individual objects based on the input data.

## Features

Ballooner is a Java Spring Boot application that provides a REST API for easier usability. The main endpoint used to generate objects is:

`[POST] /v1/ballooning/create-file`

### Request Body
- `balloonStrategyEnum` - Defines the dataset to be generated; the application supports `NASA`, `REDDIT`, `MOVIES`, `AIRLINES`, and `GISTS` field values.
- `fileSize` - The number of objects to be generated in a single file.
- `numberOfFiles` - The number of files to be generated.
- `isJsonList` - Specifies the type of file generated. The application allows two types of files to be generated:
    - JSON list ready to be loaded into memory.
    - Individual objects separated by newline characters for files too large to load into memory in their entirety.

The main idea is to create large files for testing purposes from smaller datasets and to do so as efficiently as possible. The algorithm is divided into two main stages:
1. **Factory Creation** - Based on dataset files, it creates a `Factory`. This object is then used to generate artificial data.
2. **Object Generation** - After creating the `Factory`, the application generates artificial objects using the input data.

## Additional Capabilities

The API also allows the creation of large files and the sending of data to specific sockets in the local network. Initially, we aimed to send data directly from Ballooner to flattening methods via sockets. However, generating artificial data is too slow to keep up with the flattening algorithms, which consume data faster than Ballooner can generate it in real-time. Therefore, Ballooner generates artificial data into files instead.

## Factory Creation

Given the diversity of datasets, we need to determine which objects to generate to create a factory. This decision is made based on the `BalloonStrategyEnum` object passed in the constructor. The object contains key details about the dataset, such as the file directory or object class. During the factory creation process, it is crucial to analyze object fields and measure the set of possible field values.

The algorithm preserves known values from the dataset and ensures that the artificial objects contain these known values, maintaining the probability of occurrence for each field. To make the file structure as close as possible to the dataset, we account for optional fields.

### Lazy Loading

To streamline testing, we implemented lazy loading for specific factories. If the dataset is large, factory creation takes time. Lazy loading ensures that a factory is only created once and reused for future tests. We save the factory in a map, allowing for easier reuse. Additionally, the seed of the random generator is fixed to ensure consistent test results.

## Artificial Object Creation

The factory allows for generating artificial objects. We differentiate between simple and complex objects, each with its own probability of occurrence. Complex objects can contain both simple and complex objects. Simple objects serve as containers for fields with possible values. The artificial data creation process, called `drawing`, returns a map of fields that can be used to create an output object.

### Object Structures
- **data.BalloonStrategyEnum**: Contains configurations for the specified knowledgebase, such as the initialization file or base class directory.
- **data.BalloonFactory**: Based on `BalloonStrategyEnum`, it creates `BalloonRoot` to generate artificial objects.
- **data.domain.InputBalloonData**: An interface implemented by classes that need to be ballooned. It mirrors the structure of knowledgebase objects and distinguishes between complex and simple objects.
- **data.domain.InputBalloonDataList**: Expands `ArrayList`. This indicates a list of objects that will be mapped to `BalloonFakeList`.
- **data.knowledgebase**: Contains classes and configurations responsible for processing specific files from datasets.
- **faker.BalloonFaker**: Interface providing standard methods to generate artificial objects. Implemented by `BalloonEntry`.
- **faker.BalloonEntry**: Abstract class responsible for measuring the probability of values and specific object occurrence. Each domain object implements this class.
- **faker.domain.BalloonHook**: Converts a complex `InputBalloonData` object into a `Map` of fields and `BalloonEntry`. Drawing involves applying the appropriate function on each object from the map.
- **faker.domain.BalloonFakeField**: Corresponds to simple fields like `String` or `Integer`. Based on probability, `Drawing` returns a random element from the set of known values.
- **faker.domain.BalloonFakeList**: Used for generating lists. The object list is generated by mixing the order of objects and returning the first N elements.
- **faker.domain.BalloonRoot**: Extends `BalloonHook`. Reflects the hook at the top, with specific initial conditions for functions. The `BalloonFactory` contains the root for generating objects.
- **faker.containers.ContainerFakeMap**: Created as a result of the `Drawing` object. It helps map the values and create the corresponding fake object.
- **faker.containers.ContainerFakeList**: Additional structure that facilitates detecting and mapping `BalloonFakeList` objects to the appropriate fields.
