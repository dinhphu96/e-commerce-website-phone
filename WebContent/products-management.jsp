<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Product Management</title>
	
	<link href="<c:url value="/vendor/fontawesome-free/css/all.min.css" />" rel="stylesheet">
	<link href="<c:url value="/css/sb-admin-2.min.css" />" rel="stylesheet">
	<link href="<c:url value="/vendor/datatables/dataTables.bootstrap4.min.css" />" rel="stylesheet">
   	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<style type="text/css">
	.glow-on-hover {
		width: 120px;
		height: 40px;
		border: none;
		outline: none;
		color: yellow;
		background: #111;
		cursor: pointer;
		position: relative;
		z-index: 0;
		border-radius: 8px;
		opacity: 0.7;
	}
	
	.glow-on-hover:before {
		content: '';
		background: linear-gradient(45deg, #ff0000, #ff7300, #fffb00, #48ff00, #00ffd5,
			#002bff, #7a00ff, #ff00c8, #ff0000);
		position: absolute;
		top: -2px;
		left: -2px;
		background-size: 400%;
		z-index: -1;
		filter: blur(5px);
		width: calc(100% + 4px);
		height: calc(100% + 4px);
		animation: glowing 20s linear infinite;
		opacity: 0;
		transition: opacity .3s ease-in-out;
		border-radius: 10px;
	}
	
	.glow-on-hover:active {
		color: #000
	}
	
	.glow-on-hover:active:after {
		background: transparent;
	}
	
	.glow-on-hover:hover:before {
		opacity: 1;
	}
	
	.glow-on-hover:after {
		z-index: -1;
		content: '';
		position: absolute;
		width: 100%;
		height: 100%;
		background: #111;
		left: 0;
		top: 0;
		border-radius: 10px;
	}
	
	@keyframes glowing { 
		0% {
			background-position: 0 0;
		}
		50% { 
			background-position: 400% 0;
		}
		100%{
			background-position: 0 0;
		}
	}
</style>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/jv4_asmf/admin">
                <div class="px-3" style="border: 2px solid white;">
                	<div class="sidebar-brand-icon rotate-n-15" style="font-size: 35px;"> E </div>
                </div>
                <div class="sidebar-brand-text mx-3">Elec-Pro</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="/jv4_asmf/index">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Your site</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Management</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/jv4_asmf/management-users">Users</a>
                        <a class="collapse-item" href="/jv4_asmf/management-products">Products</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="/jv4_asmf/management-bills">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Bills</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <form class="form-inline">
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <!-- Counter - Alerts -->
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                            <!-- Dropdown - Alerts -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div>
                        </li>

                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <!-- Counter - Messages -->
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler Â· 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                            alt="...">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun Â· 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                            alt="...">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez Â· 2d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                            told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Chicken the Dog Â· 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Product</h1>

					<div class="d-flex my-5">
						<div class="mx-5" style="width: 30%">
							<img alt="Prod-img" src="./img/${prodSelected.image}" style="max-width: 100%; height: auto;">
						</div>
						<form action="/jv4_asmf/management-products" method="post" style="min-width: 50%;">
							<div class="input-group my-3">
								<span style="min-width: 100px; margin-right: 5px;"> ID </span> 
								<input name="ID_Product" type="text" readonly="readonly" value="${prodSelected.ID_Product}" class="form-control form-control-sm" placeholder="ID">
							</div>
							<div class="input-group my-3">
								<span style="min-width: 100px; margin-right: 5px;"> Name </span> 
								<input name="pr_Name" type="text" value="${prodSelected.pr_Name}" class="form-control form-control-sm" placeholder="Name">
							</div>
						
							<div class="input-group mb-3">
								<span style="min-width: 100px; margin-right: 5px;"> Price </span>
								<input name="price" type="text" value="${prodSelected.price}" class="form-control form-control-sm" placeholder="Price">
							</div>
							
							<div class="input-group my-3">
								<span style="min-width: 100px; margin-right: 5px;"> Category </span>
								<div class="form-check mx-2">
									<input class="form-check-input" type="radio" name="category" id="rdoPhone" value="LMH01" style="cursor: pointer;"> 
									<label class="form-check-label" for="rdoPhone" style="cursor: pointer;">Phone </label>
								</div>
								<div class="form-check mx-2">
									<input class="form-check-input" type="radio" name="category" id="rdoLaptop" value="LMH02" style="cursor: pointer;"> 
									<label class="form-check-label" for="rdoLaptop" style="cursor: pointer;">Laptop</label>
								</div>
								<div class="form-check mx-2">
									<input class="form-check-input" type="radio" name="category" id="rdoTablet" value="LMH03" style="cursor: pointer;"> 
									<label class="form-check-label" for="rdoTablet" style="cursor: pointer;">Tablet</label>
								</div>
								<div class="form-check mx-2">
									<input class="form-check-input" type="radio" name="category" id="rdoAccessory" value="LMH04" style="cursor: pointer;"> 
									<label class="form-check-label" for="rdoAccessory" style="cursor: pointer;">Accessory</label>
								</div>
								<div class="form-check mx-2">
									<input class="form-check-input" type="radio" name="category" id="rdoSmartWatch" value="LMH05" style="cursor: pointer;"> 
									<label class="form-check-label" for="rdoSmartWatch" style="cursor: pointer;">Smart Watch</label>
								</div>
							</div>
						
							<div class="input-group my-3">
								<span style="min-width: 100px; margin-right: 5px;"> Img </span> 
								<input type="file" name="image">
							</div>
							
							<div class="input-group my-3">
								<span style="min-width: 100px; margin-right: 5px;"> Info </span> 
								<input name="info" type="text" value="${prodSelected.info}" class="form-control form-control-sm" placeholder="Info">
							</div>
							
							<div class="input-group my-3">
								<span style="min-width: 100px; margin-right: 5px;"> Quantity </span> 
								<input name="quantity" type="text" value="${prodSelected.quantity}" class="form-control form-control-sm" placeholder="Quantity">
							</div>
						
							<div class="d-flex flex-row justify-content-between">
								<button formaction="/jv4_asmf/create-product" class="glow-on-hover btn btn-primary btn-sm mt-3 px-4">Create</button>
								<button formaction="/jv4_asmf/update-product?idSelected=${prod.ID_Product}" class="glow-on-hover btn btn-primary btn-sm mt-3 px-4">Update</button>
								<button formaction="/jv4_asmf/management-products" class="glow-on-hover btn btn-primary btn-sm mt-3 px-4">Reset</button>
							</div>
						</form>
					</div>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Products</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Price</th>
                                            <th>Category</th>
                                            <th>Image</th>
                                            <th>Info</th>
                                            <th>Quantity</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="prod" items="${productList}">
                                    		<tr>
	                                            <td>${prod.ID_Product}</td>
	                                            <td>${prod.pr_Name}</td>
	                                            <td>${prod.price}</td>
	                                            <td>${prod.category.ca_Name}</td>
	                                            <td>${prod.image}</td>
	                                            <td>${prod.info}</td>
	                                            <td>${prod.quantity}</td>
	                                            <td><a href="/jv4_asmf/edit-product?idSelected=${prod.ID_Product}">Edit</a></td>
	                                            <td><a href="/jv4_asmf/delete-product?idSelected=${prod.ID_Product}">Delete</a></td>
	                                        </tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">Ã</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>
    
    <script src="<c:url value="/vendor/jquery/jquery.min.js" />"></script>
    <script src="<c:url value="/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
    <script src="<c:url value="/vendor/jquery-easing/jquery.easing.min.js" />"></script>
    <script src="<c:url value="/js/sb-admin-2.min.js" />"></script>
    <script src="<c:url value="/vendor/datatables/jquery.dataTables.min.js" />"></script>
    <script src="<c:url value="/vendor/datatables/dataTables.bootstrap4.min.js" />"></script>
    <script src="<c:url value="/js/demo/datatables-demo.js" />"></script>

</body>

</html>