<div class="row">
    <div class="col-md-7">
        <br />
        <img src="${'img/polution-' + currentModule.getSmogLevel() + '.png'}" />
    </div>
    <div class="col-md-5">
        <br />
        <br />
        <p class="text-white">PM 2.5: ${currentModule.getPm25()?string(",##0.00")}</p>
        <p class="text-white">PM 10: ${currentModule.getPm10()?string(",##0.00")}</p>
    </div>
</div>