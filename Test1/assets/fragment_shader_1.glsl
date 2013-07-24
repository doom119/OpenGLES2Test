varying vec4 v_color;
uniform sampler2D u_texture;
varying vec2 v_texCoordinate;
void main()
{
	gl_FragColor = v_color * texture2D(u_texture, v_texCoordinate);
}