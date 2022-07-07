function login() {
    let uname = document.getElementById("uname").value;
    alert(uname);
    if (uname != null && uname.trim() != null) {
        document.getElementById("loginFrom").submit();
    }
}