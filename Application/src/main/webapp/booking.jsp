<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title> Booking </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#check_in").datepicker();
            $("#check_out").datepicker();
        });
    </script>
</head>
<body>
    <Pre>
        <div> <span style="font-size: 200%; "> Choose Dates </span> </div>
        <form action="Booking">
        <pre> <label for="check_in"> Check In Date: </label> </pre>
            <input type="text" name="dob" id="check_in">
        <pre> <label for="check_out"> Check Out Date: </label> </pre>
            <input type="text" name="dob" id="check_out">
        </form>
    </pre>

    <pre>
        <form action="Booking">
            <div> <span style="font-size: 200%; "> Choose Rooms </span> </div>
            <input type="checkbox" name="chooseroom" value="Single Room"> Single Room <BR>
            <input type="checkbox" name="chooseroom" value="Double Room"> Double Room <BR>
            <input type="checkbox" name="chooseroom" value="Twin Room"> Twin Room <BR>
            <input type="checkbox" name="chooseroom" value="Deluxe Room"> Deluxe Room <BR>
        </form>
    </pre>

    <pre>
        <form action="Booking">
            <div> <span style="font-size: 200%; "> Add Pool And Gym </span> </div>
            <input type="checkbox" name="choosepool" value="Pool"> Pool <BR>
            <input type="checkbox" name="choosegym" value="Gym"> Gym <BR>
        </form>
    </pre>

    <pre>
        <form action="Booking">
            <div> <span style="font-size: 200%; "> Meals (Includes breakfast, lunch, dinner) </span> </div>
            <input type="checkbox" name="choosemeal" value="Meals"> Meals <BR>
        </form>
    </pre>

    <pre>
        <form action="Booking">
            <div> <span style="font-size: 200%; "> Finish Reservation </span> </div>
            <input type="submit" value="Finish Reservation">
        </form>
    </pre>

</body>
</html>