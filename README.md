
https://github.com/rex3212/sputnik.git

1. Чуть менее половины времени ушло на разбирательство с серверами.
Как я и говорил с JBOSS я работал мало. Поставил его, оказалось что последняя версия его кофликтует
с Java 8 окружением. Загрузил WildFly он конфликтовал с сервисами NVIDEO (использовали один и тот же порт).
После чего какое то время заняло реализовать в WildFly одновременную поддержку REST и обычных сервлетов.

2. Все работает так как описанно в тестовом задании.

3. Установка даты рабоает через JQuery плагин, но на стороне сервере дата сохраняется в строку, а не Date,
сделанно для экономии времени.

4. Для экономии времени же не использовал Bootstrap, форма максимально простая.

5. На данный момент, сохранение через rest реализованно, но работает как то глючновато, жалуется на несоответствие типа.
Попробую устранить этот баг.

Ссылки:
http://localhost:8080/sputnik/mainform  - создание пользователя
http://localhost:8080/sputnik/rest/sputnikrest/showuser  - rest просмотр пользователя (GET)
http://localhost:8080/sputnik/rest/sputnikrest/saveuser - rest сохранение(обновление) пользователя (POST)

JQuery для выгрузки пользователя, как вариант запустить в отладчике в консоле на странице
http://localhost:8080/sputnik/mainform (тут загружается JQuery)

$.post( "/sputnik/rest/sputnikrest/saveuser",
JSON.stringify({"firstName":"234","secondName":"asdfasdf","shurName":"pooad","dateOfBirth":"09/08/2015"}));
