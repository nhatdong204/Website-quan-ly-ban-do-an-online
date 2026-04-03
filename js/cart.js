function loadCart() {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    const cartList = document.getElementById("cart-list");
    cartList.innerHTML = '';
    let total = 0;

    cart.forEach((item, index) => {
        const qty = item.quantity || 1;
        total += item.price * qty;

        const div = document.createElement('div');
        div.className = 'cart-item';
        div.innerHTML = `
            <span>${item.name} - ${item.price.toLocaleString()}đ x ${qty}</span>
            <div>
                <button class="quantity-btn" onclick="changeQuantity(${index}, -1)"><i class="fa fa-minus"></i></button>
                <button class="quantity-btn" onclick="changeQuantity(${index}, 1)"><i class="fa fa-plus"></i></button>
                <button onclick="removeItem(${index})"><i class="fa fa-trash"></i> Xóa</button>
            </div>
        `;
        cartList.appendChild(div);
    });

    document.getElementById("total-price").innerText = 'Tổng tiền: ' + total.toLocaleString() + 'đ';
}

function changeQuantity(index, delta) {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    cart[index].quantity = (cart[index].quantity || 1) + delta;
    if(cart[index].quantity <= 0) cart.splice(index, 1); // xóa nếu số lượng <=0
    localStorage.setItem("cart", JSON.stringify(cart));
    loadCart();
}

function removeItem(index) {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    cart.splice(index, 1);
    localStorage.setItem("cart", JSON.stringify(cart));
    loadCart();
}

function clearCart() {
    localStorage.removeItem("cart");
    loadCart();
}

function checkout() {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    if(cart.length === 0){
        alert('Giỏ hàng trống!');
        return;
    }
    const total = cart.reduce((sum,item)=>sum + item.price*(item.quantity||1),0);
    alert(`Thanh toán thành công! Tổng: ${total.toLocaleString()}đ`);
    localStorage.removeItem("cart");
    loadCart();
}

window.onload = loadCart;