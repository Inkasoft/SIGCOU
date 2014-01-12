</div>

<div class="container footer">
	<div class="row">
		<div class="col-sm-10"></div>
		<div class="col-sm-2" style="text-align: right;">&copy; Inkasoft</div>
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function () {
		var BackgroundSlideEffect = function () {
			this.bkgs = $('.bk');
			this.currIndex = this.bkgs.length-1;
			$('.bk').css('display', 'none');
			$(this.bkgs[this.currIndex]).css('display', 'block');
		};
		
		BackgroundSlideEffect.prototype.next = function () {
			var me = this;
			var nextIndex = (me.currIndex+1 >= me.bkgs.length ? 0 : me.currIndex+1);
			var obj = $(me.bkgs[(me.currIndex == -1 ? 0 : me.currIndex)]);
			obj.css('z-index', '-999');
			$(me.bkgs[nextIndex]).fadeIn(function () {
				obj.css('display', 'none');
				$('.bk').css('z-index', '-100');
				me.currIndex = nextIndex;
				setTimeout(function () {
					me.next(); 
				}, 3000);
			});
			/* Version 1
			$.when($('.bk').fadeOut()).done(function () {
				$(me.bkgs[me.currIndex]).fadeIn(function () {
					me.currIndex++;
					if (me.currIndex == me.bkgs.length) {
						me.currIndex = 0;
					}
					setTimeout(function () {
						me.next(); 
					}, 3000);
				});
			});
			*/
		};
		
		var effectRunner = new BackgroundSlideEffect();
		effectRunner.next();
	});
</script>