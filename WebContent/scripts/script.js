$(document).ready(function() {
	
					$("#Orders").click(function() {
						$("#externalPlaceholder").load("Orders.html");
						$(window).scrollTop(0);
					});
					
					$(".toWishList").click(function() {
						console.log('redirect called');
						window.location.href = "index.html?name=WishList";
						$(window).scrollTop(0);
					});

					$("#Profile").click(function() {
						$("#externalPlaceholder").load("Profile.html");
						$(window).scrollTop(0);
					});
					
					$(".Cart-btn").click(function() {
						$("#externalPlaceholder").load("Cart.html");
						$(window).scrollTop(0);
					});

					$("#Logout").click(function() {
						$("#externalPlaceholder").html("<h2 style=\"margin: auto; width: 60%;\"><br><br>You have been logged out successfully.<br><br>Thank you and enjoy your day</h2>");
						$(window).scrollTop(0);
					});
					
					$('#ContactUs').click(function() {
						$("#externalPlaceholder").load("ContactUs.html");
						$(window).scrollTop(0);
					});
					
					$('#AboutUs').click(function() {
						$("#externalPlaceholder").load("AboutUs.html");
						$(window).scrollTop(0);
					});

					$("#Payments").click(function() {
						$("#externalPlaceholder").load("Payments.html");
						$(window).scrollTop(0);
					});
					
					$("#Return").click(function() {
						$("#externalPlaceholder").load("Return.html");
						$(window).scrollTop(0);
					});
					
					$("#FAQ").click(function() {
						$("#externalPlaceholder").load("FAQ.html");
						$(window).scrollTop(0);
						
					});
					
					$("#Shipping").click(function() {
						$("#externalPlaceholder").load("Shipping.html");
						$(window).scrollTop(0);
					});

					$("#Testimonials").click(function() {
						$("#externalPlaceholder").load("Testimonials.html");
						$(window).scrollTop(0);
					});
					
					$("#Press").click(function() {
						$("#externalPlaceholder").html("<h2>JavaMinions in the Press</h2><br><br><img width=\"50%\" src=\"images/breaking-news.png\">");
						$(window).scrollTop(0);
					});
					
					$(".dropdown").hover(function() {
						$('.dropdown-menu', this).not('.in .dropdown-menu').stop(true, true).slideDown("400");
						$(this).toggleClass('open');
						},function() {
							$('.dropdown-menu', this).not(
										'.in .dropdown-menu').stop(true, true)
										.slideUp("400");
								$(this).toggleClass('open');
							});
					

				});

