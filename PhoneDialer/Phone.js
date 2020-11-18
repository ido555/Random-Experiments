var phoneNumber = "";
var numCount = 0;
var sec = 0;
var intervalId = 0;
function appendNumber(num) {
    // add hyphen every 3 chars until there are 6 chars
    // excluding first one (0/3=0)
    if ((numCount % 3) == 0 && numCount <= 6 && numCount > 0) {
        phoneNumber = phoneNumber.concat("-")
    }
    // add num to end of phoneNumber
    phoneNumber = phoneNumber.concat(num)
    numCount += 1

    $("#phoneNumber").val(phoneNumber)
}
// truncate last char in phoneNumber
function delNumber() {
    phoneNumber = phoneNumber.slice(0, -1)
    numCount -= 1
    // dont forget hyphens
    if (phoneNumber.endsWith("-")) {
        phoneNumber = phoneNumber.slice(0, -1)
    }
    document.getElementById("phoneNumber").value = phoneNumber
}
// ajax request with jQuery
function call() {
    let areaCode = $("#areaCode").val()
    // delete all non digits from phoneNumber
    let sanitizedPhoneNumber = phoneNumber.replace(/\D+/g, '');
    if (sanitizedPhoneNumber.length < 9) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'The phone number must be at least 9 numbers long!',
        })
        return
    }
    if (areaCode == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Must enter an area code!'
        })
        return
    }
    ajaxCallStart(sanitizedPhoneNumber)
}
function ajaxCallStart(phoneNumber) {
    $.ajax
        ({
            type: "POST",
            url: 'http://localhost:8000/startCall.php',
            dataType: 'json',
            async: true,
            data: '{"areaCode": "' + $("#areaCode").val() + '", "phoneNumber" : "' + phoneNumber + '"}',
            success: function () {
                $("#numberPad").hide(400, "swing", function () {
                    $("#callPadPhoneNumber").text(phoneNumber);
                    $("#callPad").show(400, "linear", talkTime());
                })
            },
            error: function(){
                Swal.fire({
                    icon: 'error',
                    title: 'Oh no',
                    text: 'Something went wrong!',
                })
            }
        })
}
function talkTime() {
    clearInterval(intervalId);
    $("#seconds").text("00")
    $("#minutes").text("00")
    function pad(val) { return val > 9 ? val : "0" + val; }
    intervalId = setInterval(function () {
        $("#seconds").html(pad(++sec % 60));
        $("#minutes").html(pad(parseInt(sec / 60, 10)));
    }, 1000);
}

// clean up variables and end call
function endCall() {
    $("#callPad").hide(400, "linear", function () {
        phoneNumber = "";
        sanitizedPhoneNumber = "";
        numCount = 0;
        sec = 0;
        val = 0;
        $("#areaCode").val("");
        $("#phoneNumber").val("");
        $("#seconds").text("");
        $("#minutes").text("");
        $("#numberPad").show(400, "swing", talkTime());
        // TODO implement ajax request to php server to end call
    })
}

function depressButton(btnId) {
    $("#" + btnId).toggleClass("btn-muted")
    $("#" + btnId).toggleClass("btn-primary")
}
