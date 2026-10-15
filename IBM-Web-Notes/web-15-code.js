// grab the pieces we need
var form = document.getElementById("demo-form");
var slider = document.getElementById("goal");
var goalValue = document.getElementById("goal-value");
var message = document.getElementById("message");

// range shows no number itself, so copy it into the label
slider.addEventListener("input", function () {
    goalValue.textContent = "R" + slider.value;
});

// fallback check for browsers that skip the built-in validation
form.addEventListener("submit", function (event) {
    // don't send anywhere, this is only a demo
    event.preventDefault();

    var problems = [];
    var email = document.getElementById("email").value.trim();
    var phone = document.getElementById("phone").value.trim();

    // very basic email check
    if (email.indexOf("@") === -1 || email.indexOf(".") === -1) {
        problems.push("Email looks wrong.");
    }

    // 10 digits starting with 0
    if (!/^0[0-9]{9}$/.test(phone)) {
        problems.push("Phone must be 10 digits starting with 0.");
    }

    if (problems.length === 0) {
        message.textContent = "All good, the form would be sent now.";
    } else {
        message.textContent = problems.join(" ");
    }
});