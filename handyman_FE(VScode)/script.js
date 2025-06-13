const BASE_URL = "http://localhost:8080"; // Spring Boot backend URl

document.getElementById('contactForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    const formData = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('phone').value,
        message: document.getElementById('message').value,
    };

    try {
        const response = await fetch('http://localhost:8080/api/contact', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(formData),
        });

        if (response.ok) {
            alert('Your message has been sent!');
            event.target.reset();
        } else {
            alert('Failed to send message.');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('An error occurred. Please try again.');
    }
});

document.getElementById('handymanForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    const formData = {
        name: document.getElementById('handyman-name').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('phone').value,
        skills: document.getElementById('skills').value,
        areas: document.getElementById('areas').value,
    };

    try {
        const response = await fetch('http://localhost:8080/api/handyman', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(formData),
        });

        if (response.ok) {
            alert('Your application has been submitted!');
            event.target.reset();
        } else {
            alert('Failed to submit application.');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('An error occurred. Please try again.');
    }
});



//book now form code ----------------------------------------------------------------------------
function submitForm(event) {
    event.preventDefault();

    const formData = new FormData(document.getElementById("bookNowForm"));
    const jsonData = Object.fromEntries(formData);

    fetch("http://localhost:8080/api/bookings", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(jsonData),
    })
        .then(response => {
            if (response.ok) {
                alert("Booking successfully submitted!");
                document.getElementById("bookNowForm").reset();
            } else {
                alert("Failed to submit booking.");
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("An error occurred. Please try again.");
        });
}



    

    