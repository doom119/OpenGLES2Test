attribute vec3 a_position;
attribute vec4 a_color;
varying vec4 v_color;
attribute vec2 a_texCoordinate;
varying vec2 v_texCoordinate;
void main()
{
	v_color = a_color;
	v_texCoordinate = a_texCoordinate;
	gl_Position = vec4(a_position, 1.0);
}