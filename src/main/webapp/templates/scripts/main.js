function likeQuote(quoteId) {
    $.post("likeServlet", {quoteId: quoteId}, function(data) {
        $(".thumb-up").text("👍 " + data);
    });
}

function dislikeQuote(quoteId) {
    $.post("dislikeServlet", {quoteId: quoteId}, function(data) {
        $(".thumb-down").text("👎 " + data);
    });
}