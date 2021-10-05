<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="static poly.util.CmmUtil.nvl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>매입/매출현황</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="../resource/images/favicon.png">
<!-- Pignose Calender -->
<link
	href="../resource/plugins/pg-calendar/css/pignose.calendar.min.css"
	rel="stylesheet">
<!-- Chartist -->
<link rel="stylesheet"
	href="../resource/plugins/chartist/css/chartist.min.css">
<link rel="stylesheet"
	href="../resource/plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
<!-- Custom Stylesheet -->
<link href="../resource/css/style.css" rel="stylesheet">
<link href="../resource/css/saltable.css" rel="stylesheet">
<!-- 적용방법 3 제이 쿼리 제공 최신 버전-->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- 적용방법 2 : cdn -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</head>

<body>

	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none"
					stroke-width="3" stroke-miterlimit="10" />
            </svg>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->


	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<div class="nav-header">
			<div class="brand-logo">
				<a href="/main/index.do"> <b class="logo-abbr"><img
						src="../resource/images/logo.png" alt=""> </b> <span
					class="logo-compact"><img
						src="../resource/images/logo-compact.png" alt=""></span> <span
					class="brand-title"> <img
						src="../resource/images/logo-text.png" alt="">
				</span>
				</a>
			</div>
		</div>
		<!--**********************************
            Nav header end
        ***********************************-->

		<!--**********************************
            Header start
        ***********************************-->
		<div class="header">
			<div class="header-content clearfix">

				<div class="nav-control">
					<div class="hamburger">
						<span class="toggle-icon"><i class="icon-menu"></i></span>
					</div>
				</div>
				<div class="header-left">
					<div class="input-group icons"></div>
				</div>
				<div class="header-right">
					<ul class="clearfix">

						<li class="icons dropdown">
							<div class="user-img c-pointer position-relative"
								data-toggle="dropdown">
								<span class="activity active"></span> <img
									src="../resource/images/user/1.png" height="40" width="40"
									alt="">
							</div>
							<div
								class="drop-down dropdown-profile animated fadeIn dropdown-menu">
								<div class="dropdown-content-body">
									<ul>
										<li><a href="app-profile.html"><i class="icon-user"></i>
												<span>Profile</span></a></li>

										<li><a href="page-login.html"><i class="icon-key"></i>
												<span>Logout</span></a></li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="nk-sidebar">
			<div class="nk-nav-scroll">
				<ul class="metismenu" id="menu">
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"> <i class="icon-speedometer menu-icon"></i><span
							class="nav-text">가게현황</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="/main/currentsit.do">가게현황관리</a></li>

						</ul></li>
					<li class="mega-menu mega-menu-sm"><a class="has-arrow"
						href="javascript:void()" aria-expanded="false"> <i
							class="icon-globe-alt menu-icon"></i><span class="nav-text">매출현황</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="/main/daily.do">일일매출상세보기</a></li>
							<li><a href="/main/monthly.do">월별매출상세보기</a></li>
							<li><a href="/main/year.do">연도별매출상세보기</a></li>
						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"> <i class="icon-envelope menu-icon"></i>
							<span class="nav-text">급여내역</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="/main/manage.do">직원급여내역</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"> <i class="icon-screen-tablet menu-icon"></i><span
							class="nav-text">인원관리</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="/main/detail.do">직원상세정보</a></li>
						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"> <i class="icon-graph menu-icon"></i> <span
							class="nav-text">스케쥴</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="/main/calender.do">캘린더</a></li>

						</ul>
			</div>
		</div>
		<!--**********************************
            Sidebar end
        ***********************************-->

		<!--**********************************
            Content body start
        ***********************************-->
		<div class="content-body">
			<div class="container-fluid mt-3">
				<div class="row">
					<div class="col-lg-12">
						<div class="card" style="overflow: scorll;">
							<div class="card-body">
								<div class="active-member">
									<div class="table-responsive">
										<div class="sal_table" id="sal_table">
											<div style="display: inline-flex">
												<h4 style="float: left; margin-right: 600px;">매출 현황</h4>
												<div
													style="padding: 0 1rem; flex-basis: auto; white-space: nowrap; align-self: center;">

												</div>
											</div>
											<input type="button" value="추가" id="addRow">
											<form action="/main/Daily_UPDATEProc.do">
												<input type="button" value="저장" id="UpdateDailyInfo">


												<div class="divTable minimalistBlack">
													<div class="divTableHeading">
														<div class="divTableRow">
															<div class="divTableHead">
																<input type="checkbox">
															</div>
															<div class="divTableHead">순번</div>
															<div class="divTableHead">날짜</div>
															<div class="divTableHead">품목</div>
															<div class="divTableHead">가격</div>
															<div class="divTableHead">수량</div>
															<div class="divTableHead">종류</div>
															<div class="divTableHead"></div>
														</div>
													</div>
													<div class="divTableBody" id="sal_body" name="sal_body">

														<%
														for (int i = 1; i <= 10; i++) {
														%>
														<div class="divTableRow" id="sal_row" name="sal_row">
															<div class="divTableCell" id="sal_ch" name="sal_ch">
																<input type="checkbox">
															</div>
															<div class="divTableCell" id="sal_no" name="sal_no">
																<span><%=i%></span><input type="hidden" value=<%=i%>
																	class="makeArrayElem">
															</div>
															<div class="divTableCell" id="sal_date" name="sal_date">
																<input type="date" class="makeArrayElem">
															</div>
															<div class="divTableCell" id="sal_item" name="sal_item">
																<input type="text" class="makeArrayElem">
															</div>
															<div class="divTableCell" id="sal_price" name="sal_price">
																<input type="text" class="makeArrayElem">
															</div>
															<div class="divTableCell" id="sal_quantity"
																name="sal_quantity">
																<input type="text" class="makeArrayElem">
															</div>
															<div class="divTableCell" id="sal_kind" name="sal_kind">
																<select class="makeArrayElem">
																	<option>카드</option>
																	<option>현금</option>
																	<option>배달앱</option>
																</select>
															</div>
															<div class="divTableCell" id="delete" name="delete">
																<a href="#" data-toggle="tooltip" data-placement="top"
																	title="" data-original-title="Close"><i
																	class="fa fa-close color-danger" id ="rowdelete"></i></a>
															</div>
														</div>
														<input type="hidden" value=",">
														<%
														}
														%>

													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- 지각자 현황 -->
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="active-member">
									<div class="table-responsive">
										<div class="purchase_table">
											<h4>매입 현황</h4>
											<div class="divTable minimalistBlack">
												<div class="divTableHeading">
													<div class="divTableRow">
														<div class="divTableHead">
															<input type="checkbox">
														</div>
														<div class="divTableHead">순번</div>
														<div class="divTableHead">날짜</div>
														<div class="divTableHead">품목</div>
														<div class="divTableHead">가격</div>
														<div class="divTableHead">수량</div>
														<div class="divTableHead">종류</div>
													</div>
												</div>
												<div class="divTableBody">
													<%
													for (int i = 1; i <= 10; i++) {
													%>
													<div class="divTableRow">
														<div class="divTableCell" id="purchase_ch"
															name="purchase_ch">
															<input type="checkbox">
														</div>
														<div class="divTableCell" id="purchase_no"
															name="purchase_no"><%=i%></div>
														<div class="divTableCell" id="purchase_date"
															name="purchase_date">
															<input type="date">
														</div>
														<div class="divTableCell" id="purchase_item"
															name="purchase_item">
															<input type="text">
														</div>
														<div class="divTableCell" id="purchase_price"
															name="purchase_price">
															<input type="text">
														</div>
														<div class="divTableCell" id="purchase_quantity"
															name="purchase_quantity">
															<input type="text">
														</div>
														<div class="divTableCell" id="purchase_kind"
															name="purchase_kind">
															<select>
																<option>카드</option>
																<option>현금</option>
																<option>배달앱</option>
															</select>
														</div>
													</div>

													<%
													}
													%>
												</div>
												<div class="divTableFoot tableFootStyle">
													<div class="divTableRow">
														<div class="divTableCell">foot1</div>
														<div class="divTableCell">foot2</div>
														<div class="divTableCell">foot3</div>
														<div class="divTableCell">foot4</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
			<!-- #/ container -->
		</div>
		<!--**********************************
            Content body end
        ***********************************-->


		<!--**********************************
            Footer start
        ***********************************-->
		<div class="footer">
			<div class="copyright">
				<p>
					Copyright &copy; Designed & Developed by <a
						href="https://themeforest.net/user/quixlab">Quixlab</a> 2018
				</p>
			</div>
		</div>
		<!--**********************************
            Footer end
        ***********************************-->
	</div>
	<!--**********************************
        Main wrapper end
    ***********************************-->

	<!--**********************************
        Scripts
    ***********************************-->
	<script src="../resource/plugins/common/common.min.js"></script>
	<script src="../resource/js/custom.min.js"></script>
	<script src="../resource/js/settings.js"></script>
	<script src="../resource/js/gleek.js"></script>
	<script src="../resource/js/styleSwitcher.js"></script>

	<!-- Chartjs -->
	<script src="../resource/plugins/chart.js/Chart.bundle.min.js"></script>
	<!-- Circle progress -->
	<script
		src="../resource/plugins/circle-progress/circle-progress.min.js"></script>
	<!-- Datamap -->
	<script src="../resource/plugins/d3v3/index.js"></script>
	<script src="../resource/plugins/topojson/topojson.min.js"></script>
	<script src="../resource/plugins/datamaps/datamaps.world.min.js"></script>
	<!-- Morrisjs -->
	<script src="../resource/plugins/raphael/raphael.min.js"></script>
	<script src="../resource/plugins/morris/morris.min.js"></script>
	<!-- Pignose Calender -->
	<script src="../resource/plugins/moment/moment.min.js"></script>
	<script
		src="../resource/plugins/pg-calendar/js/pignose.calendar.min.js"></script>
	<!-- ChartistJS -->
	<script src="../resource/plugins/chartist/js/chartist.min.js"></script>
	<script
		src="../resource/plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>
	<script src="../resource/js/dashboard/dashboard-1.js"></script>

	<script>
    //요소에서 값을 추출하여 배열로 리턴하는 함수
    function makeArray(){
        let arr = new Array();
        let preProcess = $(".makeArrayElem").each((index, val) =>{
            arr.push($(val).val());
        });
        return arr;
    }
    // 버튼 누를 시 비동기로 백단으로 보내는 로직
    $("#UpdateDailyInfo").on("click", ()=>{
        console.log("업데이트 진입");
        let array = new Array();
        array = makeArray();
        console.log(array);
        $.ajax({
            url : '/main/Daily_UPDATEProc.do',
            type : 'post',
            data : {
            		"arr" : array,
            },
            success : result => {
                if(result === 1){
                    alert("데이터전송 성공");
                } else{
                    alert("데이터전송 실패");
                }
            }
        })
    })
    
//행 추가 버튼 클릭시 행추가
$("#addRow").on("click", ()=>{
	let row0= document.getElementById("sal_body").innerHTML;	
	let arry = new Array();
	arry = row0.split(',');
	console.log(arry[0]);
	
	$("#sal_body").append(arry[0]);	
});
    
    
    </script>


</body>

</html>