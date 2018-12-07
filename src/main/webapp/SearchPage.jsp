<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Beispiel-Design Nr.4 von SelfHTML.org">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/style.css">
    <title>CityEvents</title>
</head>

<body>
<header class="banner">
    <h1><a id="logo" title="zurück zur Startseite!" href="index.html"><img src="img/logo.png"  alt="Webseiten Name">CityEvents</a></h1>
    <a id="navlink" title="zum Navigationsmenü" href="#navigation">☰</a>
    <div class="search-container">
        <form action="/searchPostalCode" method="get">
            <select id="searchRadiusSelect" class="searchRadiusSelect" name="areaSetting">
                <option value="1">Im Umkreis von 1km</option>
                <option value="5">Im Umkreis von 5km</option>
                <option value="10">Im Umkreis von 10km</option>
                <option value="30">Im Umkreis von 30km</option>
                <option value="0">Im Umkreis von >30km</option>
            </select>
            <input id="searchBar" class="searchBar" placeholder="Nach Events in der Nähe von PLZ suchen ..." name="searchPostalCode"/>
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
    </div>


    <div class="search-container-text">
        <form action="/searchTerm">
            <input id="searchBarText" class="searchBar" placeholder="Nach einem bestimmten Event suchen ..." name="searchTerm"/>
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
    </div>

</header>

<main id="main">
    <header>
        <h1>Du hast nach <span class="akzentfarbe1"><c:out value="${searchRequest}"/></span> gesucht!</h1>
        <p>Das hier haben wir für Dich gefunden: </p>
    </header>
    <c:forEach items="${events}" var="event">
        <section class="spalte testen">
            <h2><i class="fa fa-user fa-lg"></i>${event.eventName}</h2>
            <p>${event.pitch}</p>
            <img src="img/${event.pictureName}" alt="Event-Pitch-Image">

            <c:if test="${not empty event.checkListItems}">
                <ul class="fa-ul">
                    <c:forEach items="${event.checkListItems}" var="item">
                        <li><i class="fa-li fa fa-check-square-o fa-2x"></i>${item}</li>
                    </c:forEach>
                </ul>
            </c:if>

            <c:if test="${not empty event.description}">
                <p>${event.description}</p>
            </c:if>
            <c:choose>
                <c:when test="${not empty event.price}">
                    <p class="akzentfarbe2 big fixed">${event.price} </p>
                </c:when>
                <c:otherwise>
                    <p class="akzentfarbe1 big fixed">Kostenlos!</p>
                </c:otherwise>
            </c:choose>
            <a class="button" href="1-unterseite.html">mehr Erfahren</a>
        </section>
    </c:forEach>

   <%-- <section class="spalte testen">
        <h2><i class="fa fa-user fa-lg"></i> Event 1</h2>
        <p>Kurzer Pitch</p>
        <img src="img/testen-bild.jpg" alt="Hier muss ein Beschreibungstext hin">

        <ul class="fa-ul">
            <li><i class="fa-li fa fa-check-square-o fa-2x"></i>Inhalt 1</li>
            <li><i class="fa-li fa fa-check-square-o fa-2x"></i>Inhalt 2</li>
            <li><i class="fa-li fa fa-check-square-o fa-2x"></i>Inhalt 3</li>
        </ul>
        <a class="button" href="1-unterseite.html">mehr Erfahren</a>
    </section>


    <section class="spalte suchen">
        <h2><i class="fa fa-user fa-lg"></i> Event 2</h2>
        <p>Kurzer Pitch</p>
        <img src="img/suchen-bild.jpg" alt="Hier muss ein Beschreibungstext hin">
        <p>Inhalt / Beschreibung</p>

        <p class="akzentfarbe1 big">Kostenlos!</p>

        <a class="button" href="1-unterseite.html">mehr Erfahren</a>
    </section>

    <section class="spalte suchen">
        <h2><i class="fa fa-user fa-lg"></i> Event 2</h2>
        <p>Kurzer Pitch</p>
        <img src="img/Event_03.jpg" alt="Hier muss ein Beschreibungstext hin">
        <p>Inhalt / Beschreibung</p>

        <p class="akzentfarbe2 big">€ 123,45 </p>

        <a class="button" href="1-unterseite.html">mehr Erfahren</a>
    </section>
--%>

    <footer>
        <p>Soufflé tootsie roll muffin sweet roll <a href="">liquorice wafer</a>. Macaroon topping faworki apple pie. Applicake brownie carrot
            cake. Pastry ice cream applicake jujubes sweet candy wafer. Tootsie roll  liquorice topping dessert apple pie sugar plum gingerbread. Jelly-o
            jelly-o liquorice liquorice applicake. Liquorice sweet tiramisu icing.  Powder lollipop cheesecake candy jelly beans wafer. Gummi bears tiramisu
            jelly liquorice cheesecake croissant. Lollipop ice cream cookie  gingerbread lollipop powder. </p>
    </footer>


    <!--<nav id="navigation">-->
    <!--<ul class="nav nav-pills nav-stacked">-->
    <!--<li><a aria-current="page"><i class="fa fa-home fa-fw"></i> Startseite</a></li>-->
    <!--<li><a href="1-unterseite.html" tabindex="1"><i class="fa fa-user fa-fw"></i> Mitglied werden</a>-->
    <!--<li><a href="1-unterseite.html" tabindex="2"><i class="fa fa-share-square fa-fw"></i>Sportangebote</a></li>-->
    <!--<li><a href="2-kontakt.html" tabindex="3"><i class="fa fa-envelope fa-fw"></i>Kontakt</a></li>-->
    <!--</ul>-->
    <!--</nav>      -->
</main>


<footer>
    <ul id="social">
        <li><a id="fb" href=""></a></li>
        <li><a id="twitter" href=""></a></li>
        <li><a id="yt" href=""></a></li>
    </ul>

    <p id="copyright">
        <a href="2-kontakt.html">Impressum</a><br>
        © 2013 by <a href="http://designenlassen.de/">designenlassen.de</a><br>
        überarbeitet 2018<br>
        (zur weiteren Verwendung freigegeben)
    </p>
</footer>

</body>
</html>