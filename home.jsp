<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Form</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 10px;
            padding: 10px;
            display: flex;
            justify-content: flex-start;
            align-items: flex-start;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: left;
            margin-top: 50px; /* Adjusted margin to center at the top */
            
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input,
        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	
<div class="form-center">
<form id="studentForm">
    <label for="studentFirstName">First Name:</label>
    <input type="text" id="studentFirstName" name="studentFirstName" required>

    <label for="studentMiddleName">Middle Name:</label>
    <input type="text" id="studentMiddleName" name="studentMiddleName">

    <label for="studentLastName">Last Name:</label>
    <input type="text" id="studentLastName" name="studentLastName" required>

    <label for="studentClass">Class:</label>
    <input type="text" id="studentClass" name="studentClass" required>

    <label for="studentSection">Section:</label>
    <input type="text" id="studentSection" name="studentSection">

    <label for="studentBloodGroup">Blood Group:</label>
    <input type="text" id="studentBloodGroup" name="studentBloodGroup">

    <label for="studentAddress">Address:</label>
    <textarea id="studentAddress" name="studentAddress"></textarea>

    <button type="button" onclick="submitForm()">Submit</button>
</form>
</div>

<script>
    function submitForm() {
        // Get form data
        var formData = {
            studentFirstName: document.getElementById("studentFirstName").value,
            studentMiddleName: document.getElementById("studentMiddleName").value,
            studentLastName: document.getElementById("studentLastName").value,
            studentClass: document.getElementById("studentClass").value,
            studentSection: document.getElementById("studentSection").value,
            studentBloodGroup: document.getElementById("studentBloodGroup").value,
            studentAddress: document.getElementById("studentAddress").value
        };

        // Make a POST request to your server
        fetch('/api/student/add-multiple', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify([formData]), // Assuming your backend expects an array of students
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // You can perform additional actions after successful submission
        })
        .catch((error) => {
            console.error('Error:', error);
            // Handle errors if any
        });
    }
</script>

</body>
</html>
