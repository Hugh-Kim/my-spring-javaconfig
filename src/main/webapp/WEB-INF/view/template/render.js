function render(template, model) {
    var alert = "<script type='application/javascript'>" +
        "alert('" + model.message + "');" +
    "</script>"
    return template.replace("{script}", alert);
}