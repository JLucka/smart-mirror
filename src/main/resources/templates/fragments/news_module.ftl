<div class="row">
    <h5 class="text-white">News</h5>
    <ul>
    <#list currentModule.getArticles() as article>
        <li class="text-white">${article.getTitle()}</li>
    </#list>
    </ul>
</div>
