
    function checkAll() {
        if (!checkUserId(form.userId.value)) {
            return false;
        }
        if (!checkPassword(form.userId.value, form.password1.value,    form.password2.value)) {
            return false;
        }
        if (!checkMail(form.mail.value)) {
            return false;
        }
        if (!checkName(form.name.value)) {
            return false;
        }
        if (!checkBirth(form.identi1.value, form.identi2.value)) {
            return false;
        }
        if (!checkFavorite()) {
            return false;
        }
        if (!checkIntro()) {
            return false;
        }
 
        return true;
    }
 
    // 공백확인 함수
    function checkExistData(value, dataName) {
        if (value == "") {
            alert(dataName + " 입력해주세요!");
            return false;
        }
        return true;
    }
 
    function checkUserId(id) {
        //Id가 입력되었는지 확인하기
        if (!checkExistData(id, "아이디를"))
            return false;
 
        var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
        if (!idRegExp.test(id)) {
            alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
            form.userId.value = "";
            form.userId.focus();
            return false;
        }
        return true; //확인이 완료되었을 때
    }
 
    function checkPassword(id, password1, password2) {
        //비밀번호가 입력되었는지 확인하기
        if (!checkExistData(password1, "비밀번호를"))
            return false;
        //비밀번호 확인이 입력되었는지 확인하기
        if (!checkExistData(password2, "비밀번호 확인을"))
            return false;
 
        var password1RegExp = /^[a-zA-z0-9]{4,12}$/; //비밀번호 유효성 검사
        if (!password1RegExp.test(password1)) {
            alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
            form.password1.value = "";
            form.password1.focus();
            return false;
        }
        //비밀번호와 비밀번호 확인이 맞지 않다면..
        if (password1 != password2) {
            alert("두 비밀번호가 맞지 않습니다.");
            form.password1.value = "";
            form.password2.value = "";
            form.password2.focus();
            return false;
        }
 
        //아이디와 비밀번호가 같을 때..
        if (id == password1) {
            alert("아이디와 비밀번호는 같을 수 없습니다!");
            form.password1.value = "";
            form.password2.value = "";
            form.password2.focus();
            return false;
        }
        return true; //확인이 완료되었을 때
    }
 
    function checkMail(mail) {
        //mail이 입력되었는지 확인하기
        if (!checkExistData(mail, "이메일을"))
            return false;
 
        var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
        if (!emailRegExp.test(mail)) {
            alert("이메일 형식이 올바르지 않습니다!");
            form.mail.value = "";
            form.mail.focus();
            return false;
        }
        return true; //확인이 완료되었을 때
    }
 
    function checkName(name) {
        if (!checkExistData(name, "이름을"))
            return false;
 
        var nameRegExp = /^[가-힣]{2,4}$/;
        if (!nameRegExp.test(name)) {
            alert("이름이 올바르지 않습니다.");
            return false;
        }
        return true; //확인이 완료되었을 때
    }
 
    function checkBirth(identi1, identi2) {
        //birth이 입력되었는지 확인하기
        if (!checkExistData(identi1, "주민등록번호를 ")
                || !checkExistData(identi2, "주민등록번호를 "))
            return false;
 
        var totalIdenti = "" + identi1 + identi2;
 
        var identiArr = new Array();
        var sum = 0;
        var plus = 2;
 
        //배열에 주민등록번호 입력 후 유효값 확인하기 위해 sum에 저장
        for (var i = 0; i < 12; i++) {
            identiArr[i] = totalIdenti.charAt(i);
            if (i >= 0 && i <= 7) {
                sum += totalIdenti[i] * plus;
                plus++;
                if (i == 7)
                    plus = 2;
            } else {
                sum += totalIdenti[i] * plus;
                plus++;
            }
        }
        //주민등록번호 길이 확인하기
        if (identiArr.length < 12) {
            alert("주민등록번호는 13자리입니다.");
            form.identi1.value = "";
            form.identi2.value = "";
            form.identi1.focus();
            return false;
        }
        //주민등록번호 유효한지 확인
        var result = 11 - (sum % 11) % 10
        if (result != totalIdenti.charAt(12)) { //주민등록번호가 유효하지 않은 경우
            alert("유효하지않은 주민번호입니다.");
            form.identi1.value = "";
            form.identi2.value = "";
            form.identi1.focus();
            return false;
        }
        return true; //확인이 완료되었을 때
    }
    function checkFavorite() {
        var checkedFavorite = document.getElementsByName("favorite");
 
        //체크된 값이 하나라도 있을경우 바로 true
        for (var i = 0; i < checkedFavorite.length; i++) {
            if (checkedFavorite[i].checked == true) {
                return true;
            }
        }
        alert("관심분야를 체크해주세요!");
        return false;
    }
 
    //자기소개가 입력되었는지 확인하기
    function checkIntro() {
        var text = document.getElementById("intro");
        if (!checkExistData(text.value, "자기소개를")) {
            alert("자기소개를 입력해 주세요!");
            return false;
        } else
            return true;
    }
