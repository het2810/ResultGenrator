<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Marks</title>
<style>
      /* Style the form container */
      .form-container {
        max-width: 500px;
        margin: auto;
        padding: 20px;
        background-color: #f2f2f2;
        border-radius: 5px;
      }

      /* Style the input fields */
      input[type=text], input[type=number] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
      }

      /* Style the submit button */
      input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        float: right;
      }

      /* Clear floats after the form */
      .form-container::after {
        content: "";
        clear: both;
        display: table;
      }

      /* Style the heading */
      h2 {
        text-align: center;
      }
    </style>
</head>
<body>
    <h1>Add Marks</h1>
    <form method="post" action="addMarks">
        <div>
            <label for="internalMarks">Internal Marks (out of 40):</label>
            <input type="number" id="internalMarks" name="internalMarks" min="0" max="40" required>
            <span class="error"></span>
        </div>
        <div>
            <label for="externalMarks">External Marks (out of 60):</label>
            <input type="number" id="externalMarks" name="externalMarks" min="0" max="60" required>
            <span class="error"></span>
        </div>
        <div>
            <label for="practicalMarks">Practical-Viva (out of 50):</label>
            <input type="number" id="practicalMarks" name="practicalMarks" min="0" max="50" required>
            <span class="error"></span>
        </div>
        <input type="submit" value="Submit">
    </form>
    <a href ="facultyDashboard"></a>
    <script>
        const internalMarksInput = document.getElementById("internalMarks");
        const externalMarksInput = document.getElementById("externalMarks");
        const practicalMarksInput = document.getElementById("practicalMarks");
        const errorSpans = document.querySelectorAll(".error");
        
        function validateInput() {
            if (internalMarksInput.value < parseInt(internalMarksInput.min) || internalMarksInput.value > parseInt(internalMarksInput.max)) {
                errorSpans[0].textContent = "Marks must be between " + internalMarksInput.min + " and " + internalMarksInput.max;
                return false;
            } else {
                errorSpans[0].textContent = "";
            }
            
            if (externalMarksInput.value < parseInt(externalMarksInput.min) || externalMarksInput.value > parseInt(externalMarksInput.max)) {
                errorSpans[1].textContent = "Marks must be between " + externalMarksInput.min + " and " + externalMarksInput.max;
                return false;
            } else {
                errorSpans[1].textContent = "";
            }
            
            if (practicalMarksInput.value < parseInt(practicalMarksInput.min) || practicalMarksInput.value > parseInt(practicalMarksInput.max)) {
                errorSpans[2].textContent = "Marks must be between " + practicalMarksInput.min + " and " + practicalMarksInput.max;
                return false;
            } else {
                errorSpans[2].textContent = "";
            }
            
            return true;
        }
        
        document.querySelector("form").addEventListener("submit", function(event) {
            if (!validateInput()) {
                event.preventDefault();
            }
        });
    </script>
</body>
</html>
