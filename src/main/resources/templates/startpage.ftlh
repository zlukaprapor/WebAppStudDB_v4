<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentDB</title>
    <!-- Додайте ваші стилі тут -->

    <!-- Приклад стилів для хедера -->
    <style>
        body {
            background-color: navajowhite;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        header {
            background-color: #333;
            padding: 10px;
            color: white;
            text-align: center;
        }

        #logo {
            width: 50px; /* Розмір логотипу */
            height: auto;
            vertical-align: middle;
        }

        h1 {
            display: inline-block;
            margin: 0;
            margin-left: 10px;
        }

        nav {
            display: flex;
            justify-content: space-around;
            margin-top: 10px;
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 5px;
        }

        nav a:hover {
            background-color: #555;
        }
        #search-input {
            padding: 5px;
            border-radius: 5px;
            border: none;
        }

        #search-button {
            background-color: #555;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>

<body>
<header>
<#--    <img id="logo" src="your_logo_path.png" alt="StudDB Logo">-->
    <h1>StudentDB</h1>
    <nav>
        <a href="#">Add</a>

        <input type="text" id="search-input" placeholder="Search">
        <button id="search-button">Filter</button>

        <a href="#">Login</a>
    </nav>
</header>

<!-- Додайте ваш вміст тут -->

</body>

</html>
