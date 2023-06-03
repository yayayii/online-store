# online-store
Simple online electronic store for test task.

Для запуска проекта с помощью Maven необходимо выполнить следующие команды в командной строке из папки проекта:
- `mvn clean package`
- `mvn spring-boot:run`

Для запуска проекта с помощью Docker необходимо сначала открыть приложение "_Docker Desktop_" и после этого выполнить следующие команды в командной строке из папки проекта:
- `mvn clean package`
- `docker build -t online_store_image .`
- `docker run --name online_store_container -p 8080:8080 online_store_image`

Сервер запускается по адресу:
`localhost:8080`

Спецификация api указана в файле _"api.json"_