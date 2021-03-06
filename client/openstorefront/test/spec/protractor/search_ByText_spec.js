describe('search_ByText__Filter By Text', function() {

    function textSearch (theText, numFound) {

        // Search on ALL entries (null search term)
        browser.get('http://di2e.github.io/openstorefront');
        element.all(by.css('.btn.btn-primary.pull-right')).get(2).click();

        // Verify some results are returned, doesn't matter at this point how many
        expect(element.all(by.repeater('item in data')).count()).toBeGreaterThan(0);

        // Clear the box
        var theInput = element(by.model('query'));
        theInput.clear();

        // Enter text
        theInput.sendKeys(theText);

        // Should be numFound results
        expect(element.all(by.repeater('item in data')).count()).toEqual(numFound);

        // May not always show up onscreen?
        var newest = element(by.binding('item.description'));
        expect(newest.getText()).toContain(theText);

    }

    // TODO:  Make this a 2-dimensional array and loop through it!
    var theText1 = 'DIB';
    var numFound1 = 3;
    it('Search for ' + theText1 + ' returned ' + numFound1 + ' expected results plus ' + theText1 + ' was in the search results', function () {
        textSearch(theText1, numFound1);
    });

    var theText2 = 'the S';
    var numFound2 = 4;
    it('Search for ' + theText2 + ' returned ' + numFound2 + ' expected results plus ' + theText2 + ' was in the search results', function () {
        textSearch(theText2, numFound2);
    });

    var theText3 = 'Widget';
    var numFound3 = 12;
    it('Search for ' + theText3 + ' returned ' + numFound3 + ' expected results plus ' + theText3 + ' was in the search results', function () {
        textSearch(theText3, numFound3);
    });

    var theText4 = 'widgets';
    var numFound4 = 5;
    it('Search for ' + theText4 + ' returned ' + numFound4 + ' expected results plus ' + theText4 + ' was in the search results', function () {
        textSearch(theText4, numFound4);
    });

});