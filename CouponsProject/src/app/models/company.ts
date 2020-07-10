export class Company {
    // credit to TypeScript ToolBox for auto generating 90% of this (lazy = efficent ;) )
    private companyId: Number;
    private password: Number;
    private name: String;
    private email: String;


	constructor($companyId: Number, $password: Number, $name: String, $email: String) {
		this.companyId = $companyId;
		this.password = $password;
		this.name = $name;
		this.email = $email;
	}

    /**
     * Getter $companyId
     * @return {Number}
     */
	public get $companyId(): Number {
		return this.companyId;
	}

    /**
     * Getter $password
     * @return {Number}
     */
	public get $password(): Number {
		return this.password;
	}

    /**
     * Getter $name
     * @return {String}
     */
	public get $name(): String {
		return this.name;
	}

    /**
     * Getter $email
     * @return {String}
     */
	public get $email(): String {
		return this.email;
	}

    /**
     * Setter $companyId
     * @param {Number} value
     */
	public set $companyId(value: Number) {
		this.companyId = value;
	}

    /**
     * Setter $password
     * @param {Number} value
     */
	public set $password(value: Number) {
		this.password = value;
	}

    /**
     * Setter $name
     * @param {String} value
     */
	public set $name(value: String) {
		this.name = value;
	}

    /**
     * Setter $email
     * @param {String} value
     */
	public set $email(value: String) {
		this.email = value;
	}
    
}
