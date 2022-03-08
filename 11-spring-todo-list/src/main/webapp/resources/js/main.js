const dateUL = document.querySelector(".calendar .dates ul");

const dayList = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];

const now = new Date(); // 오늘 날짜...
let pickedNow = new Date(); // 클릭했을때 넘어갈 날짜...
let firstDay = new Date(now.getFullYear(), now.getMonth(), 1); // 현재 날짜의 월에서 1일을 기준으로 새로운 date 생성
const leapYear = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; // 윤년
const nonLeapYear = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; // 윤년아님
let selectYear;

const btnNextMonth = document.querySelector(".calendar .header .next");
const btnPrevMonth = document.querySelector(".calendar .header .prev");

const txtYear = document.querySelector(".calendar .header .year");
const txtMonth = document.querySelector(".calendar .header .month");

const calendar = document.querySelector(".calendar");
let queryDate = "";
//const inputDate = document.querySelector(".inputDate");

btnPrevMonth.addEventListener("click", function() {
	pickedNow = new Date(pickedNow.getFullYear(), pickedNow.getMonth() - 1, 1);
	makeCalendar(pickedNow.getFullYear(), pickedNow.getMonth());
});
btnNextMonth.addEventListener("click", function() {
	pickedNow = new Date(pickedNow.getFullYear(), pickedNow.getMonth() + 1, 1);
	makeCalendar(pickedNow.getFullYear(), pickedNow.getMonth());
});
makeCalendar(pickedNow.getFullYear(), pickedNow.getMonth());
//inputDate.value = `${now.getFullYear()} / ${addZero(now.getMonth() + 1)} / ${addZero(now.getDate())}`;
function makeCalendar(pYear, pMonth) {
	//윤년 공식 4로 떨어지면 윤년,100년 단위는 윤년 아님, 400으로 떨어지면 윤년
	let output = "";
	let count = 1;
	firstDay = new Date(pYear, pMonth, 1);
	txtYear.textContent = firstDay.getFullYear();
	txtMonth.textContent = addZero(firstDay.getMonth() + 1);
	if (firstDay.getFullYear() % 4 === 0) {
		if (firstDay.getFullYear() % 100 === 0) {
			selectYear = nonLeapYear;
		} else {
			selectYear = leapYear;
		}
	} else {
		selectYear = nonLeapYear;
	}
	if (firstDay.getFullYear() % 400 === 0) {
		selectYear = leapYear;
	}
	queryDate = firstDay.getFullYear() + "" + addZero(firstDay.getMonth() + 1) + "" + addZero(firstDay.getDate());
	$("#pickedDate").text(addZero(now.getDate()));
	$("#pickedDay").text(dayList[now.getDay()]);
	for (let i = 0; i < 42; i++) {
		if (i < firstDay.getDay()) {
			//비워두기
			output += `<li class="blank"><span></span></li>`;
			//continue;
		} else {
			if (now.getDate() === count && now.getFullYear() === firstDay.getFullYear() && now.getMonth() === firstDay.getMonth()) {
				output += `<li class="today" data-date="${count}" data-year="${firstDay.getFullYear()}" data-month="${firstDay.getMonth() + 1}"><span>${count}</span></li>`;
			} else {
				output += `<li data-date="${count}" data-year="${firstDay.getFullYear()}" data-month="${firstDay.getMonth() + 1}"><span>${count}</span></li>`;
			}
			count += 1;
		}
		if (count > selectYear[firstDay.getMonth()]) {
			break; // 반목문이 break를 만나면 종료
		}
	}
	dateUL.innerHTML = output;
	gsap.from(".calendar .dates li", { scale: 0, ease: "power3", stagger: 0.02 });
	const dateLI = document.querySelectorAll(".calendar .dates li");
	let selectedDate;
	/* dateLI.forEach(function (item, idx) {
	   item.addEventListener("click", function () {
		 //console.log(item.dataset.date);
		 const selectDay = `${item.dataset.year}${addZero(item.dataset.month)}${addZero(parseInt(item.dataset.date))}`;
		 //console.log(selectDay);
		 if (selectedDate) {
		   selectedDate.classList.remove("on");
		 }
		 selectedDate = item;
		 selectedDate.classList.add("on");
		 queryDate = selectDay;
	   });
	 });*/
}
/*$("body").on("click", "li")*/
$("body").on("click", ".calendar .dates li", function()  {//이벤트 위임 해줘야 함
	const selectDay = $(this).data("year") + addZero($(this).data("month")) + addZero($(this).data("date"));
	/*console.log(selectDay);*/
	queryDate = selectDay;
	$(this).addClass("on").siblings().removeClass("on");

	const clickNow = new Date($(this).data("year"), parseInt($(this).data("month")) - 1, $(this).data("date")); //클릭한 날짜 기준으로 Date객체 생성
	$("#pickedDate").text(addZero(clickNow.getDate()));
	$("#pickedDay").text(dayList[clickNow.getDay()]);
	console.log(clickNow.getDay());
	console.log(clickNow.getDate());

	const sendData = {
		pickedDate: queryDate,
	};
	$.ajax({
		url: "List.do",
		data: JSON.stringify(sendData),
		contentType: "application/json",
		dataType: "json",
		method: "POST",
		success: function(res) {
			$(".todoList").html("");
			$.each(res.todoList, function(idx, item) {
				//todoList: hashMap으로 단 key값이 넘어오는 것
				$(".todoList").append(`
				 <li data-no="${item.no}" class="${item.done}">
				 	<span class="txt">${item.todo}</span>
					<button class="btnDelete">
						<span class="material-icons"> delete </span>
					</button>
				</li>
				`);
			});
		},
		error: function(err) {
			console.log(err);
		}

	})
});
function addZero(num) {
	if (num < 10) {
		return "0" + num;
	} else {
		return "" + num;
	}
}

$(".todo .btnAdd").on("click", function() {
	const sendData = {
		todo: $("#todoTxt").val(),
		done: "none",
		pickedDate: queryDate,
	};
	$.ajax({
		url: "Insert.do",
		data: JSON.stringify(sendData),
		contentType: "application/json", //보내는 데이터의 타입
		dataType: "json", //받는 데이터 타입
		method: "POST",
		success: function(res) {
			//console.log(res);
			$(".todoList").html("");
			$.each(res.todoList, function(idx, item) {
				//todoList: hashMap으로 단 key값이 넘어오는 것
				$(".todoList").append(`
				 <li data-no="${item.no}" class="${item.done}">
				 	<span class="txt">${item.todo}</span>
					<button class="btnDelete">
						<span class="material-icons"> delete </span>
					</button>
				</li>
				`);
			});
			$("#todoTxt").val("");
			$("#todoTxt").focus();
		},
		error: function(err) {
			console.log(err);
		},
	});
});
$("body").on("click", ".todoList li .txt", function() {
	//console.log("곱창");
	const clickedItem = $(this).parent();
	let state = "";
	if (clickedItem.hasClass("done")) {
		state = "none";
	} else {
		state = "done";
	}

	const sendData = {
		no: $(this).parent().data("no"),
		done: state,
	};

	$.ajax({
		url: "Update.do",
		data: JSON.stringify(sendData),
		contentType: "application/json", //보내는 데이터의 타입
		dataType: "json", //받는 데이터 타입
		method: "POST",
		success: function(res) {
			console.log(res); //{result: 1}
			if (res.result > 0) {
				if (clickedItem.hasClass("none")) {
					clickedItem.removeClass("none").addClass("done");
				} else {
					clickedItem.removeClass("done").addClass("none");
				}
			}
		},
		error: function(err) {
			console.log(err);
		},
	});

});
$("body").on("click", ".todoList li .btnDelete", function() {
	console.log($(this).parent().data("no"));
	const clickedItem = $(this).parent();
	const sendData = {
		no: $(this).parent().data("no"),
	};
	$.ajax({
		url: "Delete.do",
		data: JSON.stringify(sendData),
		contentType: "application/json", //보내는 데이터의 타입
		dataType: "json", //받는 데이터 타입
		method: "POST",
		success: function(res) {
			console.log(res); //{result: 1}
			if (res.result > 0) {
				//여기서는 $(this) 못 씀. ajax 자신을 가리키는 꼴
				gsap.to(clickedItem, {
					x: -500, ease: "power3", onComplete: function() {
						clickedItem.remove();
					}
				})
			}
		},
		error: function(err) {
			console.log(err);
		},
	});
});
