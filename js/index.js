function updateCartCount() {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    const countEl = document.getElementById("cart-count");
    if(countEl) countEl.innerText = cart.length;
}

function addToCart(name, price) {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    
    // Nếu món đã có, tăng số lượng
    const existing = cart.find(item => item.name === name);
    if(existing){
        existing.quantity = (existing.quantity || 1) + 1;
    } else {
        cart.push({name, price, quantity:1});
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    alert(name + " đã được thêm vào giỏ hàng!");
    updateCartCount();
}

// Khi load trang, cập nhật số lượng giỏ
window.onload = updateCartCount;