<div class="row">
    <p id="clock" class="text-white" style="font-size: 60pt"></p>
</div>

<script>
    setInterval(function() {
        myTimer();
    }, 1000);

    function myTimer() {
        var d = new Date();
        document.getElementById("clock").innerHTML = d.toLocaleTimeString();
    }
</script>