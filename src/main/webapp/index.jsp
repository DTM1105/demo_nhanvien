<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:catch var="catchException">
    <jsp:useBean id="listNV" scope="request" type="com.example.beans.NhanVien"/>
</c:catch>
<t:nhanVientag>
  <jsp:attribute name="css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css" integrity="sha512-f0tzWhCwVFS3WeYaofoLWkTP62ObhewQ1EZn65oSYDZUg1+CyywGKkWzm8BxaJj5HGKI72PnMH9jYyIFz+GH7g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </jsp:attribute>
    <jsp:attribute name="js">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" integrity="sha512-AIOTidJAcHBH2G/oZv9viEGXRqDNmfdPVPYOYKGy3fti0xIplnlgMHUGfuNRzC6FkzIo0iIxgFnr9RikFxK+sw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  </jsp:attribute>
<jsp:body>
            <div class="card">
                <div class="card-header">
                    Danh sách nhân viên
                </div>
                <div class="card-body">
                    <c:choose>
                        <c:when test="${listNV.size() == 0}">
                            <p class="card-text">Không có nhân viên nào.</p>
                        </c:when>
                        <c:otherwise>

                            <div>
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>Mã NV</th>
                                        <th>Tên NV</th>
                                        <th>Tuổi</th>
                                        <th>Lương</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <form action="" method="post" >
                                    <c:forEach items="${listNV}" var="c">
                                        <tr>
                                            <td><input type="text" class="form-control" value="${c.id}" name="id" id="basic-url" aria-describedby="basic-addon3"></td>
                                            <td><input type="text" class="form-control" value="${c.name}" name="name" id="basic-url1" aria-describedby="basic-addon3"></td>
                                            <td><input type="text" class="form-control" value="${c.age}" name="age" id="basic-url2" aria-describedby="basic-addon3"></td>
                                            <td><input type="text" class="form-control" value="${c.salary}" name="salary" id="basic-url3" aria-describedby="basic-addon3"></td>
                                            <td class="text-right">
                                                <button type="submit" class="btn btn-primary">
                                                    <i class=" fa fa-check" aria-hidden="true"></i>
                                                </button>
                                            </td>
                                            <td> <a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/Nhanvien/deleteNV?id=${c.id}" role="button">
                                                <i class="fa fa-trash" aria-hidden="true"></i>
                                            </a></td>
                                        </tr>
                                    </c:forEach>
                                    </form>
                                    </tbody>
                                </table>
                                <button type="submit" class="btn btn-primary">
                                    <a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/Nhanvien/addNV" role="button"></a>
                                </button>
                            </div>

                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
    </jsp:body>
</t:nhanVientag>