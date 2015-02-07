<!DOCTYPE html>
<html>
<head>
    <title>NTAAS - Naming things as a service</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link type="text/plain" rel="author" href="http://ntaas.com/humans.txt"/>
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
                    m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

        ga('create', 'UA-59457229-1', 'auto');
        ga('send', 'pageview');

    </script>
</head>
<body>

<div class="container theme-showcase" role="main">
    <div class="jumbotron">
        <h1>Naming things as a service</h1>

        <p>"The two hardest things in computing are naming things, cache invalidation and off-by-one errors." - Abe
            Lincoln, 1948
        </p>

    </div>
    <div class="content">
        <h2>Intro</h2>

        <p>Inspired by Heroku's naming convention, this web service will generate random names for your
            applications.</p>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Use the JSON API to get a random name generated:</h3>
            </div>
            <div class="panel-body">
                <div class="panel">
                    curl -H &quot;Accept: application/json&quot; http://ntaas.com/name
                </div>
                <div class="panel">
                    { &quot;name&quot; : &quot;quirky-tortoise&quot; }
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Get a numbered name</h3>
            </div>
            <div class="panel-body">
                <div class="panel">
                    curl -H &quot;Accept: application/json&quot; http://ntaas.com/name/number
                </div>
                <div class="panel">
                    { &quot;name&quot; : &quot;voracious-gear-5769&quot; }
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Nifty alliteration</h3>
            </div>
            <div class="panel-body">
                <div class="panel">
                    curl -H &quot;Accept: application/json&quot; http://ntaas.com/alliteration/s/number
                </div>
                <div class="panel">
                    { &quot;name&quot; : &quot;scintillating-soup-6039&quot; }
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container">
                <span class="text-muted">&copy; 2015 George McIntosh</span>
                <span class="text-muted"><a href="http://blog.ntaas.com">blog</a></span>
                <span class="text-muted"><a
                        href="https://twitter.com/intent/user?screen_name=namingthingsapp">follow</a></span>
            </div>
        </footer>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
</body>
</html>