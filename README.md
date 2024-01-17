<h1 >Демо-проект автоматизации тестирования UI на <a href="https://arena.tarkov.com/">Escape from Tarkov: Arena</a></h1>

![WB_logo.jpg](media/logo/arena-logo.jpg)

## :page_with_curl: Содержание

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Реализованные проверки</a>

* <a href="#allure">Allure Report отчеты</a>


<a id="tools"></a>
## Технологии и инструменты

| Java                                                                                                    | IntelliJ Idea                                                                                                                | Allure                                                                                                                    | GitHub                                                                                                    | JUnit 5                                                                                                           | Gradle                                                                                                   | Selenide                                                                                                           |
|:--------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a> | <a id ="tech" href="https://www.jetbrains.com/idea/"><img src="media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/allure-framework"><img src="media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://ru.selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> |
- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).


<a id="cases"></a>
## :heavy_check_mark: Реализованные проверки

-  Проверка содержания главной страницы
- Проверка открытия формы входа при нажатии на иконку 'Мой аккаунт' на главной странице
-   Проверка отображения главной страницы на разных языках при помощи параметризованных тестов
-  Проверка содержания товаров и категорий товаров на странице с мерчем
-  Проверка добавления и удаления товара из корзины


<a id="allure"></a>
## <img src="media/logo/Allure.svg" width="25" height="25"/></a> Allure Report отчеты

### Основное окно

<p align="center">
<img title="Allure Dashboard" src="media/screens/AllureMain.jpg">
</p>

### Отчеты по тестам

<p align="center">

> В отчете по тестам присутствует развернутая информация по запросам и ответам.

<img title="Allure Tests" src="media/screens/AllureBuild.jpg">
</p>

