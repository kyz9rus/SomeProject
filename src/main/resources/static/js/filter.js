$('.table-filters input').on('input', function () {
    filterTable($(this).parents('table'));
});

function filterTable($table) {
    var $filters = $table.find('.table-filters .input');
    var $rows = $table.find('.table-data');
    $rows.each(function () {
        var valid = true;
        if ($(this).find('.city').html().toLowerCase().indexOf(
            $filters.find('input').val().toLowerCase()) == -1)
            valid = valid && false;

        if (valid === true)
            $(this).css('display', '');
        else
            $(this).css('display', 'none');
    });
}