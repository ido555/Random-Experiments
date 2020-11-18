<?php
require __DIR__ . '/vendor/autoload.php';
use Twilio\Rest\Client;

// allow CORS, later will be changed to only allow 1 domain to improve security
header("Access-Control-Allow-Origin: *");
$data = json_decode(file_get_contents('php://input'));

$areaCode=$data->areaCode;
$phoneNumber=$data->phoneNumber;

// check that the given phone number is international
if ($phoneNumber[0] == '0') {
    // remove first char from string if it is a zero
    $phoneNumber = substr($phoneNumber,1);
}
$internationalPhoneNumber = "+" . $areaCode . $phoneNumber;
// Your Account SID and Auth Token from twilio.com/console
$account_sid = 'REDACTED';
$auth_token = 'REDACTED';

// A Twilio number you own with Voice capabilities
$twilio_number = "+12544556726";

// Where to make a voice call (your cell phone?)
$to_number = $internationalPhoneNumber;

$client = new Client($account_sid, $auth_token);
$client->account->calls->create(  
    $to_number,
    $twilio_number,
    array(
        "url" => "http://demo.twilio.com/docs/voice.xml"
    )
);
http_response_code(200);