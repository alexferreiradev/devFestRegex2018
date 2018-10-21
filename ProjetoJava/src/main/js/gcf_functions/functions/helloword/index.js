/**
 * HTTP Cloud Function.
 *
 * @param {Object} req Cloud Function request context.
 *                     More info: https://expressjs.com/en/api.html#req
 * @param {Object} res Cloud Function response context.
 *                     More info: https://expressjs.com/en/api.html#res
 */
exports.helloWorld = (req, res) => {
	var emailRegex = /\w+@.+\.com/i;

	res.send(`E-mail encontrado: ${emailRegex.exec(req.body)}!`);
};