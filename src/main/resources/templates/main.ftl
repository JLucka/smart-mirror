<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Mirror Mirror</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/mirror.css"/>
    <link rel="stylesheet" href="css/weather-icons.min.css"/>
    <script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body style="background-color: black">
<main class="container" style="padding-top: 100px">

    <div class="row">
    <#assign i=0>
    <#list modules as module>
        <#assign i=i+1>
        <#if i == 5 || i == 7 || i == 9 || i == 10>
            <div class="col-md-4 widget"></div>
        </#if>
        <#if module.isVisible()>
           <div class="col-md-4 widget">
               <#assign currentModule=module>
               <#include "fragments/" + module.name() + ".ftl">
           </div>
        <#else>
            <div class="col-md-4 widget">
            </div>
        </#if>
    </#list>
    </div>
</main>
</body>
</html>

<script>
    function reloadIfNeeded() {
        $.get("/reload-check", function (data) {
            if(data) {
                location.reload();
            }
        });
    }

    $(function() {
        setInterval(reloadIfNeeded, 1000);
    });
</script>
