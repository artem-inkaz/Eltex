# Eltex
## Авторизация на сервере и вывод информации о пользователе.
## При запуске приложения, если авторизация ранее не была произведена, приложение должно показать окно авторизации с предложением ввести имя пользователя (____) и пароль (____), (запрос /oauth/token).
## При последующих запусках приложения (и успешной авторизации) сразу открываем окно информации о пользователе, совершив запрос /user. Из полученного json вывести на экран содержимое полей: roleId, username, email (TextView), а также список permissions (RecyclerView).
## Индикация ошибок запросов с помощью Toast.
## Для работы с API использовать retrofit2.
## Получение токена:
## POST /oauth/token
## Authorization: Basic <credentials>
## Получение текущего пользователя:
## GET /user
## Authorization: Bearer <access_token>
![Screenshot_20220505-111512_My Application](https://user-images.githubusercontent.com/74608440/166863256-277f9520-e1eb-4ede-b100-2e0ba9deb76e.jpg)
![Screenshot_20220505-111417_My Application](https://user-images.githubusercontent.com/74608440/166863313-2d7b2a9a-7ddf-4ad6-aef1-fbcabbef4129.jpg)
