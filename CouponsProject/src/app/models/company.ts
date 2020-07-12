export class Company {
    // credit to TypeScript ToolBox for auto generating 90% of this (lazy = efficent ;) )
    private companyId: number;
    private password: number;
    private name: string;
    private email: string;


	constructor($companyId: number, $password: number, $name: string, $email: string) {
		this.companyId = $companyId;
		this.password = $password;
		this.name = $name;
		this.email = $email;
	}

    /**
     * Getter $companyId
     * @return {number}
     */
	public get $companyId(): number {
		return this.companyId;
	}

    /**
     * Getter $password
     * @return {number}
     */
	public get $password(): number {
		return this.password;
	}

    /**
     * Getter $name
     * @return {string}
     */
	public get $name(): string {
		return this.name;
	}

    /**
     * Getter $email
     * @return {string}
     */
	public get $email(): string {
		return this.email;
	}

    /**
     * Setter $companyId
     * @param {number} value
     */
	public set $companyId(value: number) {
		this.companyId = value;
	}

    /**
     * Setter $password
     * @param {number} value
     */
	public set $password(value: number) {
		this.password = value;
	}

    /**
     * Setter $name
     * @param {string} value
     */
	public set $name(value: string) {
		this.name = value;
	}

    /**
     * Setter $email
     * @param {string} value
     */
	public set $email(value: string) {
		this.email = value;
	}
    
}
