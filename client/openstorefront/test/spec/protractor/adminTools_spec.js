describe('adminTools', function() {
    it('Navigate from user dropdown upper right to admin tools ', function () {
        browser.get('http://di2e.github.io/openstorefront');

        // Click on User Name
        element.all(by.css('.dropdown-toggle.ng-binding')).get(0).click();

        // Click on the first dropdown menu item which is "Admin Tools"
        element.all(by.css('.dropdown-menu a')).get(0).click();

        expect(element.all(by.css('.adminTools')).count()).toEqual(1);
    });


    it('Click left menus of Admin tools and check for resulting right pane data', function() {
        // TODO:  Fill this in when coding is complete, look for more specific info on "expect"

        // Manage Attributes (highest level no sub-trees)
        element.all(by.css('.indented')).get(3).click();
        expect(element.all(by.css('.ngHeaderContainer')).count()).toEqual(1);

        // Manage Lookups (highest level no sub-trees)
        element.all(by.css('.indented')).get(5).click();
        expect(element.all(by.css('.ng-scope')).count()).toEqual(26);

        // Manage Components
        element.all(by.css('.indented')).get(7).click();
        expect(element.all(by.css('.ng-scope')).count()).toEqual(30);

        // Manage Branding
        element.all(by.css('.indented')).get(8).click();
        expect(element.all(by.css('.ng-scope')).count()).toEqual(23);

    });

});

