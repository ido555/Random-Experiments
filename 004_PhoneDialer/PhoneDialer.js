
const phoneFrame = '<iframe src="Phone.html" frameborder="0" width="350" height="400" ></iframe>'
function phoneModal(){
    Swal.fire({
        // TODO Swal does not sanitize HTML, may be a security risk?
        html: phoneFrame,
        showCancelButton: true,
        showConfirmButton: false,
        cancelButtonColor: '#d33',
        cancelButtonText: 'X'
    })
};

