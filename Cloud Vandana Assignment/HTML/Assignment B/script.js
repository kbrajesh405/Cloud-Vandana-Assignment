document.addEventListener("DOMContentLoaded", function () {
    const surveyForm = document.getElementById("surveyForm");
    const submitBtn = document.getElementById("submitBtn");
    const resetBtn = document.getElementById("resetBtn");

    submitBtn.addEventListener("click", function () {
        if (surveyForm.checkValidity()) {
            const firstName = document.getElementById("firstName").value;
            const lastName = document.getElementById("lastName").value;
            const dob = document.getElementById("dob").value;
            const country = document.getElementById("country").value;
            const genderElements = document.querySelectorAll("input[name='gender']:checked");
            const gender = [...genderElements].map(el => el.value).join(', ');
            const profession = document.getElementById("profession").value;
            const email = document.getElementById("email").value;
            const mobile = document.getElementById("mobile").value;

            const popupMessage = `
                First Name: ${firstName}
                Last Name: ${lastName}
                Date of Birth: ${dob}
                Country: ${country}
                Gender: ${gender}
                Profession: ${profession}
                Email: ${email}
                Mobile Number: ${mobile}
            `;

            alert(popupMessage);
            surveyForm.reset();
        } else {
            alert("Please fill out all required fields.");
        }
    });

    resetBtn.addEventListener("click", function () {
        surveyForm.reset();
    });
});
