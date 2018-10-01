<div class="store">
    <c:forEach items="${items}" var="item">
        <div class="item">
            <h3>Title: ${item.title}</h3>
            <div class="id">${item.id}</div>
            <div>Category: ${item.category}</div>
            <div>Subcategory: ${item.subcategory}</div>
            <div>Quantity: ${item.quantity}</div>
            <div>Price: $${item.price}</div>
            <c:choose>
                <c:when test="${item.quantity>0}">
                    <div class="order">
                        <form method="post" action="orders/addtobucket">
                            <input type="submit" class="toBucket" value="Order">
                            <input type="number" class="toBucketQuantity" value="1" name="pQuantity">
                            <input type="number" class="hidden" value="${item.id}" name="itemId">
                            <input type="text" class="hidden" value="${item.subcategory}" name="sub">
                        </form>
                    </div>
                </c:when>
                <c:otherwise>
                    <h3 style="color:red">Not available</h3>
                </c:otherwise>
            </c:choose>
        </div>
        <br/>
    </c:forEach>
</div>