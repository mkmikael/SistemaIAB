<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="UMADEB"/>
    </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <g:layoutHead/>
</head>
<body>
<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">

        <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="http://www.creative-tim.com" class="simple-text">
                    Sistema UMADEB
                </a>
            </div>

            <ul class="nav">
                <li class="${request.forwardURI == '/' ? "active" : ''}">
                    <a href="${createLink(uri: '/')}">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li class="${request.forwardURI.contains('/congregacao') ? "active" : ''}">
                    <a href="${createLink(controller: 'congregacao')}">
                        <i class="fa fa-building"></i>
                        <p>Congregações</p>
                    </a>
                </li>
                <li class="${request.forwardURI.contains('/membro') ? "active" : ''}">
                    <a href="${createLink(controller: 'membro')}">
                        <i class="fa fa-users"></i>
                        <p>Membros</p>
                    </a>
                </li>
                <li class="${request.forwardURI.contains('/movimentoEspiritual') ? "active" : ''}">
                    <a href="${createLink('controller': 'movimentoEspiritual')}">
                        <i class="fa fa-file-text"></i>
                        <p>Movimento Espiritual</p>
                    </a>
                </li>
                <li class="${request.forwardURI.contains('/lancamento') ? "active" : ''}">
                    <a href="${createLink('controller': 'lancamento')}">
                        <i class="fa fa-file-text"></i>
                        <p>Movimento Financeiro</p>
                    </a>
                </li>
                <li>
                    <a href="${createLink('controller': 'logout')}">
                        <i class="fa fa-window-close"></i>
                        <p>SAIR</p>
                    </a>
                </li>
                %{--<li>--}%
                    %{--<a href="icons.html">--}%
                        %{--<i class="ti-pencil-alt2"></i>--}%
                        %{--<p>Icons</p>--}%
                    %{--</a>--}%
                %{--</li>--}%
                %{--<li>--}%
                    %{--<a href="maps.html">--}%
                        %{--<i class="ti-map"></i>--}%
                        %{--<p>Maps</p>--}%
                    %{--</a>--}%
                %{--</li>--}%
                %{--<li>--}%
                    %{--<a href="notifications.html">--}%
                        %{--<i class="ti-bell"></i>--}%
                        %{--<p>Notifications</p>--}%
                    %{--</a>--}%
                %{--</li>--}%
                %{--<li class="active-pro">--}%
                    %{--<a href="upgrade.html">--}%
                        %{--<i class="ti-export"></i>--}%
                        %{--<p>Upgrade to PRO</p>--}%
                    %{--</a>--}%
                %{--</li>--}%
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <g:pageProperty name="page.title"/>
                    </a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        %{--<li>--}%
                            %{--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--}%
                                %{--<i class="ti-panel"></i>--}%
                                %{--<p>Stats</p>--}%
                            %{--</a>--}%
                        %{--</li>--}%

                        %{--<li class="dropdown">--}%
                            %{--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--}%
                                %{--<i class="ti-bell"></i>--}%
                                %{--<p class="notification">5</p>--}%
                                %{--<p>Notificações</p>--}%
                                %{--<b class="caret"></b>--}%
                            %{--</a>--}%
                            %{--<ul class="dropdown-menu">--}%
                                %{--<li><a href="#">Notification 1</a></li>--}%
                                %{--<li><a href="#">Notification 2</a></li>--}%
                                %{--<li><a href="#">Notification 3</a></li>--}%
                                %{--<li><a href="#">Notification 4</a></li>--}%
                                %{--<li><a href="#">Another notification</a></li>--}%
                            %{--</ul>--}%
                        %{--</li>--}%

                        %{--<li>--}%
                            %{--<a href="#">--}%
                                %{--<i class="ti-settings"></i>--}%
                                %{--<p>Settings</p>--}%
                            %{--</a>--}%
                        %{--</li>--}%
                    </ul>

                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <g:layoutBody/>
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    %{--<ul>--}%
                        %{--<li>--}%
                            %{--<a href="http://www.creative-tim.com">--}%
                                %{--Creative Tim--}%
                            %{--</a>--}%
                        %{--</li>--}%
                        %{--<li>--}%
                            %{--<a href="http://blog.creative-tim.com">--}%
                                %{--Blog--}%
                            %{--</a>--}%
                        %{--</li>--}%
                        %{--<li>--}%
                            %{--<a href="http://www.creative-tim.com/license">--}%
                                %{--Licenses--}%
                            %{--</a>--}%
                        %{--</li>--}%
                    %{--</ul>--}%
                </nav>
                <div class="copyright pull-right">
                &copy; <script>document.write(new Date().getFullYear())</script>, feito de <i class="fa fa-heart heart"></i> por Mikael Lima</a>
                </div>
            </div>
        </footer>

    </div>
</div>

<g:pageProperty name="page.modal" />
<input type="hidden" id="baseUrl" value="${createLink(uri: '/')}">
</body>
</html>
