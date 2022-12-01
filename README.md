

# Training project

## :rocket: Tools

<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="images/IDEA-logo.svg"></code>
<code><img width="5%" title="Java" src="images/java-logo.svg"></code>
<code><img width="5%" title="Selenium" src="images/selenium-logo.svg"></code>
<code><img width="5%" title="Selenide" src="images/selenide-logo.svg"></code>
<code><img width="5%" title="REST-Assured" src="images/rest-assured-logo.svg"></code>
<code><img width="5%" title="Selenoid" src="images/selenoid-logo.svg"></code>
<code><img width="5%" title="Docker" src="images/docker-logo.svg"></code>
<code><img width="5%" title="Gradle" src="images/gradle-logo.svg"></code> 
<code><img width="5%" title="JUnit5" src="images/junit5-logo.svg"></code>
<code><img width="5%" title="Allure Report" src="images/allure-Report-logo.svg"></code>
<code><img width="5%" title="Github" src="images/git-logo.svg"></code>
<code><img width="5%" title="Jenkins" src="images/jenkins-logo.svg"></code>
</p>

> *In this project, autotests are written in <code><strong>*Java*</strong></code> using the framework <code><strong>*Selenide*</strong></code> for UI-tests and <code><strong>*REST-Assured*</strong></code> for API-tests.*
>
>*Project bilder is <code><strong>*Gradle*</strong></code>.*
>
>*<code><strong>*JUnit 5*</strong></code> used as a framework for unit testing.*
>
>*The tests were run from <code><strong>*Jenkins*</strong></code>.*
>
>*<code><strong>*Selenoid*</strong></code> used to launch browsers in containers  <code><strong>*Docker*</strong></code>.*
>
>*<code><strong>*Allure Report*</strong></code> used to visualize test results.*

## :spiral_notepad: Check list

### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; UI tests

> - [x] *Проверка заголовка страницы входа в Систему*
>- [x] *Лог консоли браузера на странице входа в Систему не содержит ошибок*
>- [x] *Успешный вход в Систему*
>- [x] *Попытка входа в Систему вне рабочего расписания доступа*
>- [x] *Попытка входа в Систему с неразрешенного IP-адреса*
>- [x] *Попытка входа в Систему под пользователем с истекшим сроком доступа*
>- [x] *Попытка входа в Систему под пользователем с отключенной учетной записью*
>- [x] *Попытка входа в Систему с невалидным значением логина*


### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; API tests

>- [x] *Успешное начало процедуры восстановления пароля пользователя*
>- [x] *Ошибка начала процедуры восстановления пароля пользователя без указания логина*
>- [x] *Ошибка начала процедуры восстановления пароля пользователя по неизвестному логину*
>- [x] *Ошибка начала процедуры восстановления пароля пользователя с не подтвержденным адресом электронной почты*
>- [x] *Ошибка начала процедуры восстановления пароля пользователя с не указанным адресом электронной почты*


## :computer: Running tests from the terminal

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Running tests with completed remote.properties:*

```bash
gradle clean test
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Running tests without completed remote.properties:*

```bash
gradle clean test 
  -Dbrowser=[BROWSER]
  -DbrowserVersion=[BROWSER_VERSION]
  -DbrowserSize=[BROWSER_SIZE]
  -DremoteDriverUrl=https://[selenoidUser]:[selenoidPwd]@[REMOTE_DRIVER_URL]/wd/hub/
  -DvideoStorage=https://[REMOTE_DRIVER_URL]/video/
  -Dthreads=[THREADS]
  -DbaseUrl=[BASE_URL]
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Running Tests in Multiple Threads:*

```bash
gradle clean test -Dthreads=[threadsValue]
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Create allure report:*

```bash
allure serve build/allure-results
```

## <img width="4%" title="Jenkins" src="images/jenkins-logo.svg"> Running tests in Jenkins

### :pushpin: Build Options

    BROWSER (default chrome)
    BROWSER_VERSION (default 99.0)
    BROWSER_SIZE (default 1920x1080)
    REMOTE_DRIVER_URL (url-address selenoid, default selenoid.autotests.cloud)
    TREADS (default 5)
    BASE_URL 

<p align="center">
  <img src="images/Allure jobs history.png" alt="job" width="1000">
</p>


## <img width="4%" title="Allure Report" src="images/allure-Report-logo.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/C07-daramirra-diploma/8/allure/)
<p align="center">
  <img src="images/Allure Report.png" alt="job" width="1000"> 
</p>
