<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>memberSelect</title>
</head>
<body>
	<div>
		<span class="label">���̵�</span>
		<span>${member.id}</span>
	</div>
	<div>
		<span class="label">�н�����</span>
		<span>${member.pw}</span>
	</div>
	<div>
		<span class="label">����</span>
		<span>${member.job}</span>
	</div>
	<div>
		<span class="label">����</span>
		<span>${member.gender}</span>
	</div>
	<div>
		<span class="label">���Ե���</span>
		<span>${member.reason}</span>
	</div>
	<div>
		<span class="label">���ϼ��ſ���</span>
		<span>${member.mailyn}</span>
	</div>
	<button type="button" id="btnPage">�������</button>
<script>
	btnPage.addEventListener("click", goPage);
	function goPage() {
		//history.back();
		//history.go(-1); //������������ �̵�
		//location.href="memberAll.jsp"
		location.assign("memberAll.jsp");
	}
</script>
</body>
</html>