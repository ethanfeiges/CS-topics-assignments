<?php
    if(isset($_POST['Name'])){
        $message = $_POST['Name'];
    }
    

?>

<html>
    <form method = "post">
        <p>Name:<input type = "text" size = "5" name = "Name"></p>
        <p>Age: <input type = "text" size = "5" name = "age"> years</p>
        <p>Height: <input type = "text" size = "5" name = "height"> inches </p>
        <p> Weight: <input type = "text" size = "5" name = "weight"> lbs </p>
        <p> Select sex: <select name="sex">
            <option value="male">male</option>
            <option value="female">female</option>
        </select> </p>
        <p> Weekly exercise <input type = "text" size = "5" name = "exercise"> hrs/week</p>
        <input type="submit" name = "BMI" value = "Calculate BMI">
        <input type="submit" name = "IdealWeight" value = "Calculate Ideal Weight">
        <input type = "submit" name = "WorkoutPlan" value = "Generate Workout Plan">
    </form>
    
</html>


