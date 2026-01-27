
# Проект по автоматизации тестирования для компании [МКБ Инвестиции](https://mkb-am.ru/)

> АО «УК МКБ Инвестиции» - одна из ведущих частных управляющих компаний России, которая с 1996 года формирует успешные инвестиционные решения для всех категорий инвесторов.

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/logo/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
</p>

____
<a id="cases"></a>
## <a name="Список автоматизированных тест-кейсов">**Список автоматизированных тест-кейсов:**</a>
____
- ✓ *Проверка отображения заголовка на главной страницы с корректным текстом*
- ✓ *Проверка корректной работы чек-боксов и отображения карточек продуктов*
- ✓ *Проверка ввода некорректного номера телефона и нажатия кнопки "Свяжитесь с нами"*
- ✓ *Проверка ввода некорректного email, заполнения чек-бокса и нажатия кнопки подписки на рассылку*
- ✓ *Проверка отображения обязательной информации в нижней части сайта*
- ✓ *Проверка выбора вариантов рассылки в форме подписки*
- ✓ *Проверка отображения баннера об использовании Cookie с корректным текстом*
Часть тест-кейсов сделана параметризованными для проверки разных значений

## <a name="Список ручных тест-кейсов">**Список ручных тест-кейсов:**</a>
- ✓ *Проверка отображения всех разделов страницы "Раскрытие информации"*
- ✓ *Проверка корректной работы поиска на странице "Раскрытие информации"*
____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/038-L_Surkov-JenkinsMKBInvest_Web_Tests/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/038-L_Surkov-JenkinsMKBInvest_Web_Tests/"><img src="images/screen/jenkins_build.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- *browser (браузер, по умолчанию chrome)*
- *browserVersion (версия браузера, по умолчанию 100.0)*
- *browserSize (размер окна браузера, по умолчанию 1920x1080)*
- *configMode (выбор конфигурации для запуска)
- *remote.url (ссылка с кредами для запуска тестов в Selenoid Cloud)

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean mkb_test
```

***Удалённый запуск через Jenkins:***
```bash  
clean mkb_test
-Dbrowser=${browser}
-DbrowserVersion=${browserVersion}
-DbrowserSize=${browserSize}
-DconfigMode=remote (для удалённого запуска, local - для локального)
-Dremote.url=${REMOTE_URL} 
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/038-L_Surkov-JenkinsMKBInvest_Web_Tests/allure/#)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/jenkins.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screen/jenkins_tests.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screen/allure_graths.png" width="850">

<img title="Allure Graphics" src="images/screen/graphs.png" width="850">  
</p>

____

<a id="allure-testops"></a>
## <img alt="TestOps" height="25" src="images/logo/TestOps_logo_2.png" width="25"/></a> <a name="TestOps"></a>Интеграция с Allure TestOps [проект](https://allure.autotests.cloud/launch/51073/tree?search=W3siaWQiOiJzdGF0dXMiLCJ0eXBlIjoidGVzdFN0YXR1c0FycmF5IiwidmFsdWUiOlsicGFzc2VkIl19XQ%3D%3D&treeId=0)</a>
___
<p align="center">  
<img title="Allure TestOps Overview Dashboard" src="images/screen/TestOps.png" width="850">  
</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/telegram.png" width="550">  
</p>

____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="images/logo/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="images/video/mkb.gif" width="550" height="350"  alt="video">   
</p>

