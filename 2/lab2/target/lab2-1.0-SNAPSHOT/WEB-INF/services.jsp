<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Services - Online Programming School</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Our Services</h1>
    <p>We offer a wide range of programming courses, from beginner to advanced levels, to help you become a proficient developer.</p>

    <!-- Carousel Section -->
    <div id="servicesCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#servicesCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#servicesCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#servicesCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
            <button type="button" data-bs-target="#servicesCarousel" data-bs-slide-to="3" aria-label="Slide 4"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="carousel-caption d-none d-md-block">
                <img src="src/main/resources/images/web-development.jpg>" class="d-block w-100" alt="Web Development">
                    <h5>Web Development</h5>
                    <p>Learn how to build responsive and dynamic websites.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value='/resources/images/mobile-app-development.jpg'/>" class="d-block w-100" alt="Mobile App Development">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Mobile App Development</h5>
                    <p>Create mobile applications for iOS and Android platforms.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value='/resources/images/data-science.jpg'/>" class="d-block w-100" alt="Data Science">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Data Science</h5>
                    <p>Dive into data analysis, visualization, and predictive modeling to uncover insights from data.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value='/resources/images/machine-learning.jpg'/>" class="d-block w-100" alt="Machine Learning">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Machine Learning</h5>
                    <p>Explore algorithms and techniques to analyze and interpret complex data patterns.</p>
                </div>
            </div>
        </div>

        <button class="carousel-control-prev" type="button" data-bs-target="#servicesCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#servicesCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <button class="carousel-control-prev" type="button" data-bs-target="#servicesCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#servicesCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <ul class="mt-4">
        <li>Web Development</li>
        <li>Mobile App Development</li>
        <li>Data Science</li>
        <li>Machine Learning</li>
    </ul>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>